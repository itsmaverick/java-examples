package com.cs18000.module07;

import java.io.*;

/**
 * Demonstrates low-level (byte-oriented) file I/O
 * Uses FileOutputStream and FileInputStream
 */
public class LowLevelIO {

    public static void demonstrate() {
        System.out.println("\n=== LOW-LEVEL I/O DEMONSTRATION ===");

        File f = new File("lowlevel.dat");

        try {
            // Writing a single byte
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(42);
            fos.close();
            System.out.println("Wrote byte value: 42");

            // Reading the byte back
            FileInputStream fis = new FileInputStream(f);
            int i = fis.read();
            System.out.printf("Read byte value: %d\n", i);
            fis.close();

            // Clean up
            f.delete();

        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
