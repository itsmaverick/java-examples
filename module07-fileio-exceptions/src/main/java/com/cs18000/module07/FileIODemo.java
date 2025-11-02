package com.cs18000.module07;

import java.util.Scanner;

/**
 * Main demonstration application for Module 07
 * File I/O and Exception Handling
 *
 * CS18000 - Problem Solving and Object-Oriented Programming
 */
public class FileIODemo {

    public static void main(String[] args) {
        printHeader();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter your choice (1-7): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    LowLevelIO.demonstrate();
                    break;
                case "2":
                    HighLevelIO.demonstrate();
                    break;
                case "3":
                    ObjectIO.demonstrate();
                    break;
                case "4":
                    TextIO.demonstrate();
                    break;
                case "5":
                    ExceptionHandlingExamples.demonstrate();
                    break;
                case "6":
                    runAllDemos();
                    break;
                case "7":
                    running = false;
                    System.out.println("\nThank you for exploring File I/O and Exception Handling!");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please enter a number from 1 to 7.");
            }

            if (running && !choice.equals("6")) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void printHeader() {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  CS18000: Problem Solving and Object-Oriented Programming  ║");
        System.out.println("║          Module 07: File I/O and Exception Handling        ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }

    private static void printMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("MAIN MENU");
        System.out.println("=".repeat(60));
        System.out.println("1. Low-Level I/O (FileInputStream/FileOutputStream)");
        System.out.println("2. High-Level I/O (DataInputStream/DataOutputStream)");
        System.out.println("3. Object I/O (Serialization)");
        System.out.println("4. Text I/O (PrintWriter/BufferedReader)");
        System.out.println("5. Exception Handling Examples");
        System.out.println("6. Run All Demonstrations");
        System.out.println("7. Exit");
        System.out.println("=".repeat(60));
    }

    private static void runAllDemos() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("RUNNING ALL DEMONSTRATIONS");
        System.out.println("=".repeat(60));

        LowLevelIO.demonstrate();
        HighLevelIO.demonstrate();
        ObjectIO.demonstrate();
        TextIO.demonstrate();
        ExceptionHandlingExamples.demonstrate();

        System.out.println("\n" + "=".repeat(60));
        System.out.println("ALL DEMONSTRATIONS COMPLETED");
        System.out.println("=".repeat(60));
    }
}
