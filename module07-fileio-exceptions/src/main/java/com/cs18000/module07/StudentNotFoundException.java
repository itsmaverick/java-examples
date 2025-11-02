package com.cs18000.module07;

/**
 * Custom exception class example
 * Extends Exception to create a checked exception
 */
public class StudentNotFoundException extends Exception {

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
