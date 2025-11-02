package com.movieticket.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.movieticket.model.Movie;

import java.io.FileReader;
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
}
