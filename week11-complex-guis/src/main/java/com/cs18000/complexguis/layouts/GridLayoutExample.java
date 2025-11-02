package com.cs18000.complexguis.layouts;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

/**
 * Demonstrates GridLayout - arranges components in an m x n grid.
 * Each component takes all available space within its cell.
 * All cells are exactly the same size.
 *
 * Based on Week 11 lecture slides - pages 57-60
 */
public class GridLayoutExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("GridLayout Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a 3x4 grid layout
        JPanel panel = new JPanel(new GridLayout(3, 4));

        for (int i = 1; i <= 12; i++) {
            JButton button = new JButton("Button " + i);
            panel.add(button);
        }

        frame.add(panel);
        frame.pack(); // Set top-level window to "right" size to fit
        frame.setVisible(true);
    }
}
