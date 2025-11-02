package com.cs18000.module07;

import java.io.*;

/**
 * Demonstrates object I/O (serialization)
 * Uses ObjectOutputStream and ObjectInputStream
 */
public class ObjectIO {

    public static void demonstrate() {
        System.out.println("\n=== OBJECT I/O DEMONSTRATION ===");

        File f = new File("object.dat");

        try {
            // Writing an object
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Tree tree1 = new Tree(42.5, "elm");
            oos.writeObject(tree1);
            oos.close();

            System.out.println("Wrote tree1 = " + tree1);

            // Reading the object back
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Tree tree2 = (Tree) ois.readObject();
            ois.close();

            System.out.println("Read  tree2 = " + tree2);

            System.out.println("\nNote: The class must implement Serializable interface!");
            System.out.println("Note: Objects are different instances but have same data.");

            // Clean up
            f.delete();

        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
        }
    }
}
