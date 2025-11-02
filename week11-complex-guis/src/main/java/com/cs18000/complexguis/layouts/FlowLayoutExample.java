package com.cs18000.complexguis.layouts;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * Demonstrates FlowLayout - the default layout manager for JPanels.
 * Components flow left-to-right, top-to-bottom, wrapping as needed.
 *
 * Based on Week 11 lecture slides - pages 53-56
 */
public class FlowLayoutExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // JPanel defaults to FlowLayout
        JPanel panel = new JPanel();

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton("Button " + i);
            panel.add(button);
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}
