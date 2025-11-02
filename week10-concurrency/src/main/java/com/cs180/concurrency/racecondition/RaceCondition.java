package com.cs180.concurrency.racecondition;

/**
 * Demonstrates a race condition where two threads increment a shared counter.
 * WITHOUT proper synchronization, the final count will often be LESS than expected
 * because updates can be lost when threads interleave their read-modify-write operations.
 */
public class RaceCondition implements Runnable {
    private static int counter;

    public static void main(String[] args) {
        System.out.println("=== Race Condition Demo (NO Synchronization) ===\n");
        System.out.println("Running multiple trials to show inconsistent results...\n");

        for (int trial = 1; trial <= 5; trial++) {
            counter = 0;

            Thread t1 = new Thread(new RaceCondition());
            Thread t2 = new Thread(new RaceCondition());

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Trial %d: counter = %d (expected 20000)\n", trial, counter);
        }

        System.out.println("\nNotice how the results are inconsistent and often less than 20000!");
        System.out.println("This is because of RACE CONDITIONS where updates are lost.");
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            // This simple operation actually consists of three steps:
            // 1. Read counter into temp variable
            // 2. Increment temp variable
            // 3. Write temp variable back to counter
            // When threads interleave, updates can be lost!
            counter++;
        }
    }
}
