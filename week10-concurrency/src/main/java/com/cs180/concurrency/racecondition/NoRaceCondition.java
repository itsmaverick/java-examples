package com.cs180.concurrency.racecondition;

/**
 * Demonstrates how to FIX race conditions using synchronized blocks.
 * WITH proper synchronization, the final count will ALWAYS be correct
 * because only one thread can execute the critical section at a time.
 */
public class NoRaceCondition implements Runnable {
    private static int counter = 0;
    private static Object gateKeeper = new Object();

    public static void main(String[] args) {
        System.out.println("=== No Race Condition Demo (WITH Synchronization) ===\n");
        System.out.println("Running multiple trials to show CONSISTENT results...\n");

        for (int trial = 1; trial <= 5; trial++) {
            counter = 0;

            Thread t1 = new Thread(new NoRaceCondition());
            Thread t2 = new Thread(new NoRaceCondition());

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

        System.out.println("\nNotice how the results are ALWAYS 20000!");
        System.out.println("This is because the synchronized block prevents race conditions.");
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            // The synchronized block ensures that only ONE thread at a time
            // can execute counter++, preventing lost updates
            synchronized (gateKeeper) {
                counter++;
            }
        }
    }
}
