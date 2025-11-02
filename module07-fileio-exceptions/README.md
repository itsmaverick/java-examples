# Module 07: File I/O and Exception Handling

**CS18000: Problem Solving and Object-Oriented Programming**

This Maven project demonstrates the concepts covered in Module 07, including File I/O operations and Exception Handling in Java.

## Table of Contents

- [Project Structure](#project-structure)
- [Concepts Demonstrated](#concepts-demonstrated)
- [Building the Project](#building-the-project)
- [Running the Application](#running-the-application)
- [Key Concepts](#key-concepts)

## Project Structure

```
module07-fileio-exceptions/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── cs18000/
                    └── module07/
                        ├── FileIODemo.java                    (Main application)
                        ├── LowLevelIO.java                    (Byte-level I/O)
                        ├── HighLevelIO.java                   (Primitive type I/O)
                        ├── ObjectIO.java                      (Object serialization)
                        ├── Tree.java                          (Serializable example class)
                        ├── TextIO.java                        (Text file I/O)
                        ├── ExceptionHandlingExamples.java     (Exception handling demos)
                        └── StudentNotFoundException.java      (Custom exception)
```

## Concepts Demonstrated

### File I/O

1. **Low-Level I/O** (`LowLevelIO.java`)
   - Byte-oriented file operations
   - `FileInputStream` and `FileOutputStream`
   - Reading and writing raw bytes

2. **High-Level I/O** (`HighLevelIO.java`)
   - Java primitive type I/O
   - `DataInputStream` and `DataOutputStream`
   - Writing and reading int, double, boolean, String, etc.
   - **Important**: Data must be read in the same order it was written!

3. **Object I/O** (`ObjectIO.java` and `Tree.java`)
   - Object serialization
   - `ObjectInputStream` and `ObjectOutputStream`
   - The `Serializable` interface
   - Saving and loading entire objects

4. **Text I/O** (`TextIO.java`)
   - Human-readable text files
   - `PrintWriter` for output
   - `BufferedReader` for input
   - File append mode

### Exception Handling

5. **Exception Handling Examples** (`ExceptionHandlingExamples.java`)
   - Basic try-catch blocks
   - Multiple catch blocks (ordered from specific to general)
   - Finally clause (guaranteed execution)
   - Try-with-resources statement (automatic resource management)
   - Custom exceptions
   - Throws clause

6. **Custom Exceptions** (`StudentNotFoundException.java`)
   - Creating custom exception classes
   - Extending the `Exception` class
   - Checked vs. unchecked exceptions

## Building the Project

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Build Commands

```bash
# Navigate to project directory
cd module07-fileio-exceptions

# Compile the project
mvn compile

# Package the project
mvn package
```

## Running the Application

### Option 1: Using Maven

```bash
mvn exec:java
```

### Option 2: Using Java directly

```bash
# After building
java -cp target/module07-fileio-exceptions-1.0-SNAPSHOT.jar com.cs18000.module07.FileIODemo
```

### Option 3: Open in VS Code

1. Open VS Code
2. File → Open Folder
3. Navigate to `module07-fileio-exceptions`
4. Open `FileIODemo.java`
5. Click the "Run" button above the main method

## Key Concepts

### File I/O Layers in Java

Java provides three layers of abstraction for file I/O:

1. **Low-Level** (Byte-oriented)
   - Classes: `FileOutputStream`, `FileInputStream`
   - Raw data transfer

2. **High-Level** (Java primitive types)
   - Classes: `DataOutputStream`, `DataInputStream`
   - Type-safe I/O operations

3. **Object I/O** (Java object types)
   - Classes: `ObjectOutputStream`, `ObjectInputStream`
   - Requires `Serializable` interface

### Important File I/O Concepts

- **Buffering**: Improves performance by reducing physical disk access
- **Closing Files**: Always close files to flush buffers and free resources
- **Append Mode**: `new FileOutputStream(file, true)` appends to existing files
- **Text vs. Binary**: Text files are human-readable, binary files are not

### Exception Handling

#### Checked vs. Unchecked Exceptions

- **Checked Exceptions** (must handle with try-catch or throws)
  - `IOException`, `FileNotFoundException`
  - Generally indicate user/environment errors
  - Usually recoverable

- **Unchecked Exceptions** (optional to handle)
  - `RuntimeException` and subclasses
  - `NullPointerException`, `ArrayIndexOutOfBoundsException`
  - Generally indicate programming errors
  - Usually not recoverable

#### Exception Handling Syntax

```java
// Basic try-catch
try {
    // Code that might throw exception
} catch (SpecificException e) {
    // Handle specific exception
} catch (GeneralException e) {
    // Handle general exception
} finally {
    // Always executes (optional)
}

// Try-with-resources (automatic resource management)
try (ResourceType resource = new ResourceType()) {
    // Use resource
} // Resource automatically closed here

// Throws clause
public void method() throws IOException {
    // Method can throw IOException
}
```

### Best Practices

1. **Always close resources** (or use try-with-resources)
2. **Catch specific exceptions first**, then general ones
3. **Use appropriate exception types** for different error conditions
4. **Provide meaningful error messages** in custom exceptions
5. **Read data in the same order it was written** (for DataInputStream)
6. **Make classes Serializable** if they need to be saved to files

## Learning Objectives

After exploring this project, you should understand:

- ✓ How to read and write files at different abstraction levels
- ✓ The importance of buffering for performance
- ✓ How to serialize and deserialize objects
- ✓ The difference between text and binary files
- ✓ How to use try-catch blocks for error handling
- ✓ The difference between checked and unchecked exceptions
- ✓ How to create custom exception classes
- ✓ How to use try-with-resources for automatic resource management
- ✓ How exceptions propagate through the call stack

## Additional Resources

- Java I/O Tutorial: https://docs.oracle.com/javase/tutorial/essential/io/
- Exception Handling: https://docs.oracle.com/javase/tutorial/essential/exceptions/

---

**Note**: This project is for educational purposes and demonstrates concepts from CS18000 Module 07.
