// API Base URL
const API_BASE_URL = 'http://localhost:8080/api';

// DOM Elements
const movieForm = document.getElementById('movieForm');
const formTitle = document.getElementById('formTitle');
const submitBtn = document.getElementById('submitBtn');
const cancelBtn = document.getElementById('cancelBtn');
const message = document.getElementById('message');
const moviesTableBody = document.getElementById('moviesTableBody');

// Form fields
const movieId = document.getElementById('movieId');
const titleInput = document.getElementById('title');
const genreInput = document.getElementById('genre');
const directorInput = document.getElementById('director');
const releaseYearInput = document.getElementById('releaseYear');
const durationInput = document.getElementById('duration');
const ratingInput = document.getElementById('rating');
const priceInput = document.getElementById('price');
const descriptionInput = document.getElementById('description');
const castInput = document.getElementById('cast');
const posterUrlInput = document.getElementById('posterUrl');

// State
let editingMovieId = null;
let allMovies = [];

// Initialize
init();

function init() {
    setupEventListeners();
    loadMovies();
}

function setupEventListeners() {
    movieForm.addEventListener('submit', handleSubmit);
    cancelBtn.addEventListener('click', resetForm);
}

// Load all movies
async function loadMovies() {
    try {
        const response = await fetch(`${API_BASE_URL}/movies`);
        if (!response.ok) throw new Error('Failed to load movies');

        allMovies = await response.json();
        displayMovies(allMovies);
    } catch (err) {
        showMessage('Failed to load movies: ' + err.message, 'error');
        console.error('Error loading movies:', err);
    }
}

// Display movies in table
function displayMovies(movies) {
    moviesTableBody.innerHTML = '';

    if (movies.length === 0) {
        moviesTableBody.innerHTML = '<tr><td colspan="8" style="text-align: center;">No movies found</td></tr>';
        return;
    }

    movies.forEach(movie => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${escapeHtml(movie.id)}</td>
            <td>${escapeHtml(movie.title)}</td>
            <td>${escapeHtml(movie.genre)}</td>
            <td>${escapeHtml(movie.director)}</td>
            <td>${movie.releaseYear}</td>
            <td>⭐ ${movie.rating.toFixed(1)}</td>
            <td>$${movie.price.toFixed(2)}</td>
            <td class="actions-cell">
                <button class="btn btn-edit" onclick="editMovie('${movie.id}')">Edit</button>
                <button class="btn btn-danger" onclick="deleteMovie('${movie.id}')">Delete</button>
            </td>
        `;
        moviesTableBody.appendChild(row);
    });
}

// Handle form submission
async function handleSubmit(e) {
    e.preventDefault();

    const movieData = {
        title: titleInput.value.trim(),
        genre: genreInput.value.trim(),
        director: directorInput.value.trim(),
        releaseYear: parseInt(releaseYearInput.value),
        duration: parseInt(durationInput.value),
        rating: parseFloat(ratingInput.value),
        price: parseFloat(priceInput.value),
        description: descriptionInput.value.trim(),
        cast: castInput.value.split(',').map(actor => actor.trim()).filter(actor => actor !== ''),
        posterUrl: posterUrlInput.value.trim() || ''
    };

    try {
        if (editingMovieId) {
            await updateMovie(editingMovieId, movieData);
        } else {
            await createMovie(movieData);
        }
    } catch (err) {
        showMessage('Operation failed: ' + err.message, 'error');
    }
}

// Create a new movie
async function createMovie(movieData) {
    try {
        const response = await fetch(`${API_BASE_URL}/movies`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(movieData)
        });

        if (!response.ok) {
            const error = await response.json();
            throw new Error(error.message || 'Failed to create movie');
        }

        const createdMovie = await response.json();
        showMessage(`Movie "${createdMovie.title}" created successfully!`, 'success');
        resetForm();
        loadMovies();
    } catch (err) {
        throw err;
    }
}

// Update an existing movie
async function updateMovie(id, movieData) {
    try {
        const response = await fetch(`${API_BASE_URL}/movies/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(movieData)
        });

        if (!response.ok) {
            const error = await response.json();
            throw new Error(error.message || 'Failed to update movie');
        }

        const updatedMovie = await response.json();
        showMessage(`Movie "${updatedMovie.title}" updated successfully!`, 'success');
        resetForm();
        loadMovies();
    } catch (err) {
        throw err;
    }
}

// Edit movie - populate form
function editMovie(id) {
    const movie = allMovies.find(m => m.id === id);
    if (!movie) {
        showMessage('Movie not found', 'error');
        return;
    }

    editingMovieId = id;
    formTitle.textContent = 'Edit Movie';
    submitBtn.textContent = 'Update Movie';

    movieId.value = movie.id;
    titleInput.value = movie.title;
    genreInput.value = movie.genre;
    directorInput.value = movie.director;
    releaseYearInput.value = movie.releaseYear;
    durationInput.value = movie.duration;
    ratingInput.value = movie.rating;
    priceInput.value = movie.price;
    descriptionInput.value = movie.description;
    castInput.value = movie.cast.join(', ');
    posterUrlInput.value = movie.posterUrl || '';

    // Scroll to form
    document.querySelector('.form-container').scrollIntoView({ behavior: 'smooth' });
}

// Delete movie
async function deleteMovie(id) {
    const movie = allMovies.find(m => m.id === id);
    if (!movie) {
        showMessage('Movie not found', 'error');
        return;
    }

    if (!confirm(`Are you sure you want to delete "${movie.title}"?`)) {
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/movies/${id}`, {
            method: 'DELETE'
        });

        if (!response.ok) {
            const error = await response.json();
            throw new Error(error.message || 'Failed to delete movie');
        }

        showMessage(`Movie "${movie.title}" deleted successfully!`, 'success');
        loadMovies();
    } catch (err) {
        showMessage('Failed to delete movie: ' + err.message, 'error');
        console.error('Error deleting movie:', err);
    }
}

// Reset form
function resetForm() {
    movieForm.reset();
    editingMovieId = null;
    formTitle.textContent = 'Add New Movie';
    submitBtn.textContent = 'Add Movie';
    movieId.value = '';
}

// Show message
function showMessage(text, type) {
    message.textContent = text;
    message.className = `message ${type}`;
    message.classList.remove('hidden');

    // Auto-hide after 5 seconds
    setTimeout(() => {
        message.classList.add('hidden');
    }, 5000);
}

// Escape HTML to prevent XSS
function escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}
