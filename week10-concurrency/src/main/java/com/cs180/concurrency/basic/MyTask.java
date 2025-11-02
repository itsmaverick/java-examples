package com.cs180.concurrency.basic;

/**
 * Demonstrates creating a thread using the Runnable interface.
 * This is the recommended approach for creating threads in Java.
 */
public class MyTask implements Runnable {
    public static void main(String[] args) {
        MyTask m = new MyTask();
        Thread t = new Thread(m);

        t.start();
    }

    public void run() {
        System.out.printf("now in %s\n", Thread.currentThread());
    }
}
