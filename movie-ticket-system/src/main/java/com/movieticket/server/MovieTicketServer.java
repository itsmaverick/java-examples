package com.movieticket.server;

import com.google.gson.Gson;
import com.movieticket.model.Movie;
import com.movieticket.service.MovieService;
import spark.Request;
import spark.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

/**
 * Main server class for Movie Ticket System
 * Provides REST API endpoints for movie information
 */
public class MovieTicketServer {
    private static final int PORT = 8080;
    private static final String DATA_FILE = "src/main/resources/data/movies.json";
    private static MovieService movieService;
    private static Gson gson;

    public static void main(String[] args) {
        gson = new Gson();
        movieService = new MovieService(DATA_FILE);

        // Configure server
        port(PORT);

        // Enable CORS
        enableCORS();

        // Define API routes FIRST
        setupRoutes();

        System.out.println("========================================");
        System.out.println("Movie Ticket Server started successfully!");
        System.out.println("Server running on: http://localhost:" + PORT);
        System.out.println("API Base URL: http://localhost:" + PORT + "/api");
        System.out.println("Web UI: http://localhost:" + PORT + "/index.html");
        System.out.println("========================================");
    }

    /**
     * Setup all REST API routes
     */
    private static void setupRoutes() {
        // Explicit routes for static files - MUST be defined BEFORE other routes
        get("/index.html", (req, res) -> serveStaticFile(req, res));
        get("/styles.css", (req, res) -> serveStaticFile(req, res));
        get("/app.js", (req, res) -> serveStaticFile(req, res));

        // Root endpoint
        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });

        // API Health check
        get("/api/health", (req, res) -> {
            res.type("application/json");
            Map<String, String> status = new HashMap<>();
            status.put("status", "UP");
            status.put("service", "Movie Ticket System");
            return gson.toJson(status);
        });

        // Get all movies
        get("/api/movies", MovieTicketServer::getAllMovies);

        // Get movie by ID
        get("/api/movies/:id", MovieTicketServer::getMovieById);

        // Search movies by title
        get("/api/movies/search/:query", MovieTicketServer::searchMovies);

        // Get movies by genre
        get("/api/movies/genre/:genre", MovieTicketServer::getMoviesByGenre);

        // Get all genres
        get("/api/genres", MovieTicketServer::getAllGenres);

        // Reload movies from file
        post("/api/reload", MovieTicketServer::reloadMovies);

        // Handle 404
        notFound((req, res) -> {
            res.type("application/json");
            Map<String, String> error = new HashMap<>();
            error.put("error", "Not Found");
            error.put("message", "The requested resource was not found");
            return gson.toJson(error);
        });

        // Handle exceptions
        exception(Exception.class, (exception, request, response) -> {
            response.status(500);
            response.type("application/json");
            Map<String, String> error = new HashMap<>();
            error.put("error", "Internal Server Error");
            error.put("message", exception.getMessage());
            response.body(gson.toJson(error));
        });
    }

    /**
     * Get all movies endpoint
     */
    private static String getAllMovies(Request req, Response res) {
        res.type("application/json");
        List<Movie> movies = movieService.getAllMovies();
        return gson.toJson(movies);
    }

    /**
     * Get movie by ID endpoint
     */
    private static String getMovieById(Request req, Response res) {
        res.type("application/json");
        String id = req.params(":id");
        Movie movie = movieService.getMovieById(id);

        if (movie != null) {
            return gson.toJson(movie);
        } else {
            res.status(404);
            Map<String, String> error = new HashMap<>();
            error.put("error", "Movie not found");
            error.put("id", id);
            return gson.toJson(error);
        }
    }

    /**
     * Search movies by title endpoint
     */
    private static String searchMovies(Request req, Response res) {
        res.type("application/json");
        String query = req.params(":query");
        List<Movie> movies = movieService.searchMoviesByTitle(query);
        return gson.toJson(movies);
    }

    /**
     * Get movies by genre endpoint
     */
    private static String getMoviesByGenre(Request req, Response res) {
        res.type("application/json");
        String genre = req.params(":genre");
        List<Movie> movies = movieService.getMoviesByGenre(genre);
        return gson.toJson(movies);
    }

    /**
     * Get all genres endpoint
     */
    private static String getAllGenres(Request req, Response res) {
        res.type("application/json");
        List<String> genres = movieService.getAllGenres();
        return gson.toJson(genres);
    }

    /**
     * Reload movies from file endpoint
     */
    private static String reloadMovies(Request req, Response res) {
        res.type("application/json");
        movieService.reloadMovies();
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Movies reloaded from file");
        return gson.toJson(response);
    }

    /**
     * Serve static files (HTML, CSS, JS)
     */
    private static String serveStaticFile(Request req, Response res) {
        String fileName = req.pathInfo();
        if (fileName.startsWith("/")) {
            fileName = fileName.substring(1);
        }

        System.out.println("Serving static file: " + fileName);

        String filePath = "src/main/resources/static/" + fileName;
        File file = new File(filePath);

        System.out.println("Looking for file at: " + file.getAbsolutePath());

        if (!file.exists()) {
            res.status(404);
            System.err.println("File not found: " + file.getAbsolutePath());
            return "File not found: " + fileName + " (looked at: " + file.getAbsolutePath() + ")";
        }

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Set content type based on file extension
            if (fileName.endsWith(".html")) {
                res.type("text/html");
            } else if (fileName.endsWith(".css")) {
                res.type("text/css");
            } else if (fileName.endsWith(".js")) {
                res.type("application/javascript");
            }

            System.out.println("Successfully served: " + fileName + " (" + content.length() + " bytes)");
            return content;
        } catch (IOException e) {
            res.status(500);
            System.err.println("Error reading file: " + e.getMessage());
            return "Error reading file: " + e.getMessage();
        }
    }

    /**
     * Enable CORS for cross-origin requests
     */
    private static void enableCORS() {
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
        });
    }
}
