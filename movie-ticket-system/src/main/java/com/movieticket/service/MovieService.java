package com.movieticket.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.movieticket.model.Movie;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing movie operations
 */
public class MovieService {
    private List<Movie> movies;
    private final Gson gson;
    private final String dataFilePath;

    public MovieService(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.gson = new Gson();
        this.movies = new ArrayList<>();
        loadMoviesFromFile();
    }

    /**
     * Load movies from JSON file
     */
    private void loadMoviesFromFile() {
        try (FileReader reader = new FileReader(dataFilePath)) {
            Type movieListType = new TypeToken<List<Movie>>(){}.getType();
            movies = gson.fromJson(reader, movieListType);
            System.out.println("Successfully loaded " + movies.size() + " movies from file");
        } catch (IOException e) {
            System.err.println("Error loading movies from file: " + e.getMessage());
            movies = new ArrayList<>();
        }
    }

    /**
     * Get all movies
     */
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    /**
     * Get a movie by ID
     */
    public Movie getMovieById(String id) {
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Search movies by title
     */
    public List<Movie> searchMoviesByTitle(String title) {
        String lowerCaseTitle = title.toLowerCase();
        return movies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(lowerCaseTitle))
                .collect(Collectors.toList());
    }

    /**
     * Get movies by genre
     */
    public List<Movie> getMoviesByGenre(String genre) {
        String lowerCaseGenre = genre.toLowerCase();
        return movies.stream()
                .filter(movie -> movie.getGenre().toLowerCase().equals(lowerCaseGenre))
                .collect(Collectors.toList());
    }

    /**
     * Get all unique genres
     */
    public List<String> getAllGenres() {
        return movies.stream()
                .map(Movie::getGenre)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Reload movies from file
     */
    public void reloadMovies() {
        loadMoviesFromFile();
    }

    /**
     * Create a new movie
     */
    public Movie createMovie(Movie movie) {
        // Generate ID if not provided
        if (movie.getId() == null || movie.getId().isEmpty()) {
            movie.setId(generateNextId());
        }

        // Check if ID already exists
        if (getMovieById(movie.getId()) != null) {
            throw new IllegalArgumentException("Movie with ID " + movie.getId() + " already exists");
        }

        movies.add(movie);
        saveMoviesToFile();
        System.out.println("Created new movie: " + movie.getTitle() + " (ID: " + movie.getId() + ")");
        return movie;
    }

    /**
     * Update an existing movie
     */
    public Movie updateMovie(String id, Movie updatedMovie) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId().equals(id)) {
                updatedMovie.setId(id); // Ensure ID doesn't change
                movies.set(i, updatedMovie);
                saveMoviesToFile();
                System.out.println("Updated movie: " + updatedMovie.getTitle() + " (ID: " + id + ")");
                return updatedMovie;
            }
        }
        throw new IllegalArgumentException("Movie with ID " + id + " not found");
    }

    /**
     * Delete a movie by ID
     */
    public boolean deleteMovie(String id) {
        boolean removed = movies.removeIf(movie -> movie.getId().equals(id));
        if (removed) {
            saveMoviesToFile();
            System.out.println("Deleted movie with ID: " + id);
        }
        return removed;
    }

    /**
     * Save movies to JSON file
     */
    private void saveMoviesToFile() {
        try (FileWriter writer = new FileWriter(dataFilePath)) {
            gson.toJson(movies, writer);
            System.out.println("Successfully saved " + movies.size() + " movies to file");
        } catch (IOException e) {
            System.err.println("Error saving movies to file: " + e.getMessage());
            throw new RuntimeException("Failed to save movies", e);
        }
    }

    /**
     * Generate next available ID
     */
    private String generateNextId() {
        int maxId = movies.stream()
                .map(Movie::getId)
                .filter(id -> id.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(0);
        return String.valueOf(maxId + 1);
    }
}
