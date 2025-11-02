package com.cs18000.module07;

import java.io.*;

/**
 * Demonstrates text file I/O
 * Uses PrintWriter for output and BufferedReader for input
 */
public class TextIO {

    public static void demonstrate() {
        System.out.println("\n=== TEXT I/O DEMONSTRATION ===");

        File f = new File("textio.txt");

        try {
            // Writing text to file with PrintWriter
            FileOutputStream fos = new FileOutputStream(f, false); // false = overwrite
            PrintWriter pw = new PrintWriter(fos);

            pw.println("Line 1: Hello, World!");
            pw.println("Line 2: This is text I/O");
            pw.printf("Line 3: Formatted output: %d, %.2f\n", 42, 3.14159);
            pw.close();

            System.out.println("Wrote 3 lines to file");

            // Reading text from file with BufferedReader
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);

            System.out.println("\nReading lines from file:");
            int lineCount = 0;
            while (true) {
                String s = bfr.readLine();
                if (s == null) {
                    break;  // End of file
                }
                lineCount++;
                System.out.println("  " + s);
            }
            bfr.close();

            System.out.printf("\nRead %d lines from file\n", lineCount);

            // Demonstrating append mode
            FileOutputStream fos2 = new FileOutputStream(f, true); // true = append
            PrintWriter pw2 = new PrintWriter(fos2);
            pw2.println("Line 4: Appended line");
            pw2.close();

            System.out.println("\nAppended one more line");

            // Clean up
            f.delete();

        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
