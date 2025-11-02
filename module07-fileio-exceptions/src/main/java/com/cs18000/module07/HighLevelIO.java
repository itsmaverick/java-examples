package com.cs18000.module07;

import java.io.*;

/**
 * Demonstrates high-level (primitive type) file I/O
 * Uses DataOutputStream and DataInputStream
 */
public class HighLevelIO {

    public static void demonstrate() {
        System.out.println("\n=== HIGH-LEVEL I/O DEMONSTRATION ===");

        File f = new File("highlevel.dat");

        try {
            // Writing primitive types
            FileOutputStream fos = new FileOutputStream(f);
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeInt(1000);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("Hello, World!");
            dos.close();

            System.out.println("Wrote: int=1000, double=3.14159, boolean=true, String='Hello, World!'");

            // Reading primitive types back
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);

            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean boolValue = dis.readBoolean();
            String stringValue = dis.readUTF();
            dis.close();

            System.out.printf("Read: int=%d, double=%.5f, boolean=%b, String='%s'\n",
                    intValue, doubleValue, boolValue, stringValue);

            // Important: Data must be read in the same order it was written!
            System.out.println("\nNote: Data must be read in the SAME ORDER it was written!");

            // Clean up
            f.delete();

        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
