package com.cs180.concurrency;

import com.cs180.concurrency.basic.*;
import com.cs180.concurrency.taskdecomposition.*;
import com.cs180.concurrency.domaindecomposition.*;
import com.cs180.concurrency.synchronization.*;
import com.cs180.concurrency.racecondition.*;

import java.util.Scanner;

/**
 * Main entry point for running all concurrency examples.
 * Provides an interactive menu to run different demonstrations.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("\nEnter your choice (0-9): ");

            String input = scanner.nextLine().trim();

            System.out.println("\n" + "=".repeat(60) + "\n");

            switch (input) {
                case "1":
                    System.out.println("Running MainThread example...\n");
                    MainThread.main(new String[]{});
                    break;

                case "2":
                    System.out.println("Running MyTask example...\n");
                    MyTask.main(new String[]{});
                    break;

                case "3":
                    System.out.println("Running Interleave example...\n");
                    Interleave.main(new String[]{});
                    break;

                case "4":
                    System.out.println("Running Game Simulation (Task Decomposition)...\n");
                    GameSimulation.main(new String[]{});
                    break;

                case "5":
                    System.out.println("Running Matrix Multiplication (Domain Decomposition)...\n");
                    MatrixMultiplication.main(new String[]{});
                    break;

                case "6":
                    System.out.println("Running File Search with join()...\n");
                    FileSearchDemo.main(new String[]{});
                    break;

                case "7":
                    System.out.println("Running Race Condition Demo (UNSAFE)...\n");
                    RaceCondition.main(new String[]{});
                    break;

                case "8":
                    System.out.println("Running No Race Condition Demo (SAFE)...\n");
                    NoRaceCondition.main(new String[]{});
                    break;

                case "9":
                    System.out.println("Running Bank Account Race Condition...\n");
                    BankAccountRace.main(new String[]{});
                    break;

                case "0":
                    System.out.println("Running ALL examples...\n");
                    runAllExamples();
                    break;

                case "q":
                case "Q":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (running && !input.equals("q") && !input.equals("Q")) {
                System.out.println("\n" + "=".repeat(60));
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  JAVA CONCURRENCY DEMONSTRATIONS - Week 10");
        System.out.println("=".repeat(60));
        System.out.println("\nBASIC THREAD CONCEPTS:");
        System.out.println("  1. MainThread - Basic thread operations (sleep, yield)");
        System.out.println("  2. MyTask - Creating threads with Runnable");
        System.out.println("  3. Interleave - Thread execution interleaving");
        System.out.println("\nDECOMPOSITION PATTERNS:");
        System.out.println("  4. Game Simulation - Task Decomposition (Model/View)");
        System.out.println("  5. Matrix Multiplication - Domain Decomposition");
        System.out.println("\nSYNCHRONIZATION:");
        System.out.println("  6. File Search - Thread synchronization with join()");
        System.out.println("\nRACE CONDITIONS:");
        System.out.println("  7. Race Condition - Demonstrates the problem (UNSAFE)");
        System.out.println("  8. No Race Condition - Shows the solution (SAFE)");
        System.out.println("  9. Bank Account - Real-world race condition example");
        System.out.println("\nOTHER OPTIONS:");
        System.out.println("  0. Run ALL examples");
        System.out.println("  Q. Quit");
    }

    private static void runAllExamples() {
        String[] examples = {
            "Basic Thread Operations",
            "Creating Threads with Runnable",
            "Thread Interleaving",
            "Task Decomposition - Game",
            "Domain Decomposition - Matrix",
            "Thread Synchronization - File Search",
            "Race Condition (UNSAFE)",
            "No Race Condition (SAFE)",
            "Bank Account Race"
        };

        for (int i = 0; i < examples.length; i++) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("Example " + (i + 1) + "/" + examples.length + ": " + examples[i]);
            System.out.println("=".repeat(60) + "\n");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (i) {
                case 0: MainThread.main(new String[]{}); break;
                case 1: MyTask.main(new String[]{}); break;
                case 2: Interleave.main(new String[]{}); break;
                case 3: GameSimulation.main(new String[]{}); break;
                case 4: MatrixMultiplication.main(new String[]{}); break;
                case 5: FileSearchDemo.main(new String[]{}); break;
                case 6: RaceCondition.main(new String[]{}); break;
                case 7: NoRaceCondition.main(new String[]{}); break;
                case 8: BankAccountRace.main(new String[]{}); break;
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("ALL EXAMPLES COMPLETED!");
        System.out.println("=".repeat(60));
    }
}
