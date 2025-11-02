package com.cs18000.complexguis.layouts;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

/**
 * Demonstrates BorderLayout - divides pane into 5 regions:
 * CENTER, NORTH, SOUTH, EAST, WEST.
 * This is the default layout for JFrame's content pane.
 *
 * Based on Week 11 lecture slides - pages 18-21
 */
public class BorderLayoutExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // JFrame content pane uses BorderLayout by default
        JButton jbCenter = new JButton("Center");
        JButton jbNorth = new JButton("North");
        JButton jbSouth = new JButton("South");
        JButton jbEast = new JButton("East");
        JButton jbWest = new JButton("West");

        frame.add(jbCenter, BorderLayout.CENTER);
        frame.add(jbNorth, BorderLayout.NORTH);
        frame.add(jbSouth, BorderLayout.SOUTH);
        frame.add(jbEast, BorderLayout.EAST);
        frame.add(jbWest, BorderLayout.WEST);

        frame.setVisible(true);
    }
}
