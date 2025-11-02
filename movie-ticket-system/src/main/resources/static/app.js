// API Base URL
const API_BASE_URL = 'http://localhost:8080/api';

// DOM Elements
const searchInput = document.getElementById('searchInput');
const searchBtn = document.getElementById('searchBtn');
const clearBtn = document.getElementById('clearBtn');
const genreFilter = document.getElementById('genreFilter');
const moviesContainer = document.getElementById('moviesContainer');
const loading = document.getElementById('loading');
const error = document.getElementById('error');
const movieModal = document.getElementById('movieModal');
const closeModal = document.querySelector('.close');
const movieDetail = document.getElementById('movieDetail');

// State
let allMovies = [];
let currentMovies = [];

// Initialize the application
async function init() {
    setupEventListeners();
    await loadGenres();
    await loadMovies();
}

// Setup event listeners
function setupEventListeners() {
    searchBtn.addEventListener('click', handleSearch);
    clearBtn.addEventListener('click', handleClear);
    genreFilter.addEventListener('change', handleGenreFilter);
    closeModal.addEventListener('click', closeMovieModal);
    movieModal.addEventListener('click', (e) => {
        if (e.target === movieModal) {
            closeMovieModal();
        }
    });

    // Search on Enter key
    searchInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') {
            handleSearch();
        }
    });
}

// Load all genres
async function loadGenres() {
    try {
        const response = await fetch(`${API_BASE_URL}/genres`);
        if (!response.ok) throw new Error('Failed to load genres');

        const genres = await response.json();
        genreFilter.innerHTML = '<option value="">All Genres</option>';

        genres.forEach(genre => {
            const option = document.createElement('option');
            option.value = genre;
            option.textContent = genre;
            genreFilter.appendChild(option);
        });
    } catch (err) {
        console.error('Error loading genres:', err);
    }
}

// Load all movies
async function loadMovies() {
    showLoading();
    hideError();

    try {
        console.log('Fetching movies from:', `${API_BASE_URL}/movies`);
        const response = await fetch(`${API_BASE_URL}/movies`);

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        allMovies = await response.json();
        currentMovies = allMovies;

        console.log(`Loaded ${allMovies.length} movies from database`);
        displayMovies(currentMovies);
        updateMovieCount(currentMovies.length);
    } catch (err) {
        showError('Failed to load movies. Please make sure the server is running on http://localhost:8080');
        console.error('Error loading movies:', err);
    } finally {
        hideLoading();
    }
}

// Handle search
async function handleSearch() {
    const query = searchInput.value.trim();

    if (!query) {
        handleClear();
        return;
    }

    showLoading();
    hideError();

    try {
        const response = await fetch(`${API_BASE_URL}/movies/search/${encodeURIComponent(query)}`);
        if (!response.ok) throw new Error('Search failed');

        currentMovies = await response.json();
        displayMovies(currentMovies);
        updateMovieCount(currentMovies.length);

        if (currentMovies.length === 0) {
            showError(`No movies found matching "${query}"`);
        }
    } catch (err) {
        showError('Search failed. Please try again.');
        console.error('Error searching movies:', err);
    } finally {
        hideLoading();
    }
}

// Handle clear search
function handleClear() {
    searchInput.value = '';
    genreFilter.value = '';
    currentMovies = allMovies;
    displayMovies(currentMovies);
    updateMovieCount(currentMovies.length);
    hideError();
}

// Handle genre filter
async function handleGenreFilter() {
    const selectedGenre = genreFilter.value;

    if (!selectedGenre) {
        currentMovies = allMovies;
        displayMovies(currentMovies);
        updateMovieCount(currentMovies.length);
        return;
    }

    showLoading();
    hideError();

    try {
        const response = await fetch(`${API_BASE_URL}/movies/genre/${encodeURIComponent(selectedGenre)}`);
        if (!response.ok) throw new Error('Failed to filter by genre');

        currentMovies = await response.json();
        displayMovies(currentMovies);
        updateMovieCount(currentMovies.length);

        if (currentMovies.length === 0) {
            showError(`No movies found in genre "${selectedGenre}"`);
        }
    } catch (err) {
        showError('Failed to filter movies. Please try again.');
        console.error('Error filtering movies:', err);
    } finally {
        hideLoading();
    }
}

// Display movies in grid
function displayMovies(movies) {
    moviesContainer.innerHTML = '';

    if (movies.length === 0) {
        moviesContainer.innerHTML = '<p style="grid-column: 1/-1; text-align: center; color: white; font-size: 1.2em;">No movies to display</p>';
        return;
    }

    movies.forEach(movie => {
        const movieCard = createMovieCard(movie);
        moviesContainer.appendChild(movieCard);
    });
}

// Create movie card element
function createMovieCard(movie) {
    const card = document.createElement('div');
    card.className = 'movie-card';
    card.onclick = () => showMovieDetail(movie);

    card.innerHTML = `
        <div class="movie-poster">🎬</div>
        <div class="movie-info">
            <h2 class="movie-title">${escapeHtml(movie.title)}</h2>
            <div class="movie-meta">
                <span class="movie-genre">${escapeHtml(movie.genre)}</span>
                <span class="movie-rating">⭐ ${movie.rating.toFixed(1)}</span>
            </div>
            <p class="movie-description">${escapeHtml(movie.description)}</p>
            <div class="movie-price">$${movie.price.toFixed(2)}</div>
        </div>
    `;

    return card;
}

// Show movie detail modal
async function showMovieDetail(movie) {
    movieDetail.innerHTML = `
        <div class="detail-header">
            <h2 class="detail-title">${escapeHtml(movie.title)}</h2>
            <div class="detail-meta">
                <span class="detail-badge">${escapeHtml(movie.genre)}</span>
                <span class="detail-badge">⭐ ${movie.rating.toFixed(1)}</span>
                <span class="detail-badge">${movie.releaseYear}</span>
                <span class="detail-badge">${movie.duration} mins</span>
            </div>
        </div>

        <div class="detail-section">
            <h3>Description</h3>
            <p>${escapeHtml(movie.description)}</p>
        </div>

        <div class="detail-section">
            <h3>Director</h3>
            <p>${escapeHtml(movie.director)}</p>
        </div>

        <div class="detail-section">
            <h3>Cast</h3>
            <div class="cast-list">
                ${movie.cast.map(actor => `<span class="cast-item">${escapeHtml(actor)}</span>`).join('')}
            </div>
        </div>

        <div class="price-tag">
            Ticket Price: $${movie.price.toFixed(2)}
        </div>
    `;

    movieModal.classList.remove('hidden');
}

// Close movie detail modal
function closeMovieModal() {
    movieModal.classList.add('hidden');
}

// Show loading indicator
function showLoading() {
    loading.classList.remove('hidden');
}

// Hide loading indicator
function hideLoading() {
    loading.classList.add('hidden');
}

// Show error message
function showError(message) {
    error.textContent = message;
    error.classList.remove('hidden');
}

// Hide error message
function hideError() {
    error.classList.add('hidden');
}

// Escape HTML to prevent XSS
function escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}

// Update movie count display
function updateMovieCount(count) {
    const countElement = document.getElementById('movieCount');
    if (countElement) {
        countElement.textContent = `Showing ${count} movie${count !== 1 ? 's' : ''}`;
    }
}

// Start the application
init();
