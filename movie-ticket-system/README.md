# Movie Ticket System

A modern client-server movie ticket booking system built with Java and Maven. The system features a RESTful API backend that serves movie information from a JSON file, and a beautiful web-based UI for browsing and viewing movie details.

## Features

- **RESTful API Server**: Built with Spark Java framework
- **File-based Data Storage**: Movie information stored in JSON format
- **Web UI**: Modern, responsive interface for browsing movies
- **Search Functionality**: Search movies by title
- **Genre Filtering**: Filter movies by genre
- **Detailed Movie Information**: View comprehensive details including cast, director, rating, and price
- **CORS Enabled**: Cross-origin requests supported

## Architecture

```
movie-ticket-system/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/movieticket/
│       │       ├── model/
│       │       │   └── Movie.java          # Movie data model
│       │       ├── service/
│       │       │   └── MovieService.java   # Business logic layer
│       │       └── server/
│       │           └── MovieTicketServer.java  # REST API server
│       └── resources/
│           ├── data/
│           │   └── movies.json             # Movie database
│           └── static/
│               ├── index.html              # Web UI
│               ├── styles.css              # Styling
│               └── app.js                  # Client-side logic
└── pom.xml                                 # Maven configuration
```

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- A web browser (Chrome, Firefox, Safari, etc.)

## Installation

1. Clone or download the project:
```bash
cd java-examples/movie-ticket-system
```

2. Verify Maven installation:
```bash
mvn --version
```

## Building the Project

Compile and package the application:

```bash
mvn clean package
```

This will:
- Compile all Java sources
- Download all dependencies
- Run tests (if any)
- Create an executable JAR file in the `target/` directory

## Running the Application

### Option 1: Run with Maven

```bash
mvn exec:java -Dexec.mainClass="com.movieticket.server.MovieTicketServer"
```

### Option 2: Run the JAR file

```bash
java -jar target/movie-ticket-system-1.0.0.jar
```

### Option 3: Run with Java directly (for development)

```bash
mvn compile
java -cp target/classes:$(mvn dependency:build-classpath -Dmdep.outputFile=/dev/stdout -q) com.movieticket.server.MovieTicketServer
```

## Accessing the Application

Once the server is running, you'll see:

```
========================================
Movie Ticket Server started successfully!
Server running on: http://localhost:8080
API Base URL: http://localhost:8080/api
Web UI: http://localhost:8080/index.html
========================================
```

Open your browser and navigate to:
- **Web UI**: http://localhost:8080/index.html
- **API Endpoints**: http://localhost:8080/api

## API Endpoints

### Health Check
```
GET /api/health
```
Check if the server is running.

### Get All Movies
```
GET /api/movies
```
Returns a list of all available movies.

### Get Movie by ID
```
GET /api/movies/{id}
```
Returns detailed information about a specific movie.

**Example**: `GET /api/movies/1`

### Search Movies
```
GET /api/movies/search/{query}
```
Search movies by title (case-insensitive, partial match).

**Example**: `GET /api/movies/search/dark`

### Get Movies by Genre
```
GET /api/movies/genre/{genre}
```
Filter movies by genre.

**Example**: `GET /api/movies/genre/Action`

### Get All Genres
```
GET /api/genres
```
Returns a list of all unique genres.

### Reload Movies
```
POST /api/reload
```
Reload movie data from the JSON file (useful after updating the file).

## Using the Web Interface

1. **Browse Movies**: All movies are displayed in a grid layout
2. **Search**: Enter a movie title in the search box and click "Search"
3. **Filter by Genre**: Select a genre from the dropdown menu
4. **View Details**: Click on any movie card to see full details
5. **Clear Filters**: Click "Clear" to reset all filters

## Managing Movie Data

Movie data is stored in `src/main/resources/data/movies.json`. You can:

1. Add new movies by adding entries to the JSON array
2. Edit existing movie information
3. Remove movies by deleting entries

### Movie Data Structure

```json
{
  "id": "unique-id",
  "title": "Movie Title",
  "genre": "Genre",
  "director": "Director Name",
  "releaseYear": 2024,
  "duration": 120,
  "rating": 8.5,
  "description": "Movie description...",
  "cast": ["Actor 1", "Actor 2"],
  "posterUrl": "",
  "price": 12.99
}
```

After updating the data file, restart the server or use the reload endpoint:

```bash
curl -X POST http://localhost:8080/api/reload
```

## Testing the API

### Using curl

```bash
# Get all movies
curl http://localhost:8080/api/movies

# Get a specific movie
curl http://localhost:8080/api/movies/1

# Search movies
curl http://localhost:8080/api/movies/search/inception

# Get movies by genre
curl http://localhost:8080/api/movies/genre/Action

# Get all genres
curl http://localhost:8080/api/genres
```

### Using a web browser

Simply navigate to the endpoints in your browser:
- http://localhost:8080/api/movies
- http://localhost:8080/api/genres

## Configuration

### Change Server Port

Edit `MovieTicketServer.java` and modify the PORT constant:

```java
private static final int PORT = 8080; // Change to your desired port
```

### Change Data File Location

Edit `MovieTicketServer.java` and modify the DATA_FILE constant:

```java
private static final String DATA_FILE = "src/main/resources/data/movies.json";
```

## Troubleshooting

### Port Already in Use

If port 8080 is already in use, you'll see an error. Either:
1. Change the port in the code (see Configuration section)
2. Stop the application using port 8080

### File Not Found Error

Ensure you're running the application from the project root directory where `src/main/resources/data/movies.json` is accessible.

### Dependencies Not Downloaded

Run:
```bash
mvn clean install
```

### CORS Issues

The server has CORS enabled by default. If you still face issues, check your browser's console for specific error messages.

## Technologies Used

- **Java 11**: Programming language
- **Maven**: Build and dependency management
- **Spark Java**: Lightweight web framework for REST API
- **Gson**: JSON parsing library
- **HTML/CSS/JavaScript**: Frontend technologies
- **SLF4J**: Logging framework

## Project Structure Explained

- **Model Layer** (`model/Movie.java`): Defines the data structure for movies
- **Service Layer** (`service/MovieService.java`): Handles business logic and file I/O
- **Server Layer** (`server/MovieTicketServer.java`): REST API endpoints and server configuration
- **Static Resources**: Web UI files (HTML, CSS, JavaScript)
- **Data**: JSON file containing movie information

## Future Enhancements

Potential features to add:
- User authentication and authorization
- Booking system for movie tickets
- Seat selection functionality
- Payment integration
- Admin panel for managing movies
- Database integration (PostgreSQL, MySQL, etc.)
- Movie showtimes and theater locations
- User reviews and ratings
- Persistent storage for bookings

## License

This project is for educational purposes.

## Contributors

Built with Claude Code

---

**Note**: This is a demonstration project showcasing client-server architecture with REST API and file-based storage.
