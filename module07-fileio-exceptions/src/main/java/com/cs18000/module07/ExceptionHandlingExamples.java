package com.cs18000.module07;

import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * Demonstrates various exception handling concepts
 */
public class ExceptionHandlingExamples {

    public static void demonstrate() {
        System.out.println("\n=== EXCEPTION HANDLING DEMONSTRATIONS ===");

        demonstrateTryCatch();
        demonstrateMultipleCatch();
        demonstrateFinally();
        demonstrateTryWithResources();
        demonstrateCustomException();
    }

    /**
     * Basic try-catch example
     */
    private static void demonstrateTryCatch() {
        System.out.println("\n--- Basic Try-Catch ---");

        File f = new File("nonexistent.txt");

        try {
            FileReader fr = new FileReader(f);
            System.out.println("File opened successfully");
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        System.out.println("Program continues after exception handling");
    }

    /**
     * Multiple catch blocks example
     */
    private static void demonstrateMultipleCatch() {
        System.out.println("\n--- Multiple Catch Blocks ---");

        try {
            int[] array = {1, 2, 3};
            System.out.println("Accessing array[5]...");
            System.out.println(array[5]); // Will throw ArrayIndexOutOfBoundsException

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());

        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Caught general Exception: " + e.getMessage());
        }

        System.out.println("Note: Catches must be ordered from most specific to most general!");
    }

    /**
     * Finally clause example
     */
    private static void demonstrateFinally() {
        System.out.println("\n--- Finally Clause ---");

        FileWriter fw = null;
        try {
            File f = new File("finally_test.txt");
            fw = new FileWriter(f);
            fw.write("Testing finally clause\n");
            System.out.println("File written successfully");

        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());

        } finally {
            System.out.println("Finally block executing (always runs!)");
            if (fw != null) {
                try {
                    fw.close();
                    System.out.println("File closed in finally block");
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
            // Clean up test file
            new File("finally_test.txt").delete();
        }
    }

    /**
     * Try-with-resources example
     */
    private static void demonstrateTryWithResources() {
        System.out.println("\n--- Try-with-Resources ---");

        File f = new File("try_with_resources.txt");

        try {
            // Write file
            try (PrintWriter pw = new PrintWriter(f)) {
                pw.println("Line 1");
                pw.println("Line 2");
                System.out.println("File written using try-with-resources");
            } // PrintWriter automatically closed here!

            // Read file
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line;
                System.out.println("Reading file:");
                while ((line = br.readLine()) != null) {
                    System.out.println("  " + line);
                }
            } // BufferedReader automatically closed here!

            System.out.println("Resources automatically closed - no finally block needed!");

        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        } finally {
            f.delete();
        }
    }

    /**
     * Custom exception example
     */
    private static void demonstrateCustomException() {
        System.out.println("\n--- Custom Exception ---");

        try {
            findStudent(12345);
        } catch (StudentNotFoundException e) {
            System.out.println("Caught StudentNotFoundException: " + e.getMessage());
        }
    }

    /**
     * Method that throws a custom exception
     */
    private static void findStudent(int studentId) throws StudentNotFoundException {
        // Simulating a search that fails
        if (studentId != 99999) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found");
        }
        System.out.println("Student found!");
    }

    /**
     * Demonstrates exception propagation (throwing exceptions)
     */
    public static void demonstrateThrows() throws IOException {
        System.out.println("\n--- Throws Clause ---");
        System.out.println("This method declares 'throws IOException'");
        System.out.println("It passes the responsibility to handle exceptions to the caller");

        // This method could throw IOException but doesn't catch it
        File f = new File("test.txt");
        FileReader fr = new FileReader(f); // May throw FileNotFoundException
        fr.close();
    }
}
