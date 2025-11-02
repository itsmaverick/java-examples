package com.cs18000.complexguis.basic;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

/**
 * Demonstrates creating a basic JFrame using SwingUtilities.invokeLater
 * This is the recommended way to launch GUI applications.
 *
 * Based on Week 11 lecture slides - pages 12, 29-30
 */
public class EmptyFrame {

    public static void main(String[] args) {
        // Execute all GUI-related code on the EDT (Event Dispatch Thread)
        // This causes the run() method to execute inside the EDT.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame jf = new JFrame("Empty Frame");
        jf.setSize(640, 480);

        // Use DISPOSE_ON_CLOSE for graceful shutdown
        // NOT EXIT_ON_CLOSE (equivalent to System.exit())
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jf.setVisible(true);
    }
}
