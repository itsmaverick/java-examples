package com.cs180.concurrency.basic;

/**
 * Demonstrates thread interleaving - how two threads running simultaneously
 * will interleave their output. This shows the unpredictability of thread execution.
 */
public class Interleave implements Runnable {
    private char c;

    public Interleave(char c) {
        this.c = c;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.printf("%c", c);
            // Do some work to make the interleaving more visible
            for (int j = 0; j < 1000; j++)
                Math.hypot(i, j);
        }
        System.out.printf("%c", Character.toUpperCase(c));
    }

    public static void main(String[] args) {
        for (int iteration = 0; iteration < 3; iteration++) {
            Thread t1 = new Thread(new Interleave('a'));
            Thread t2 = new Thread(new Interleave('b'));

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
