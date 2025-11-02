package com.cs18000.complexguis.layouts;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;

/**
 * Demonstrates using sub-panels and BorderFactory to create
 * complex layouts with visual borders.
 *
 * Based on Week 11 lecture slides - pages 63-69
 */
public class SubPanelExample {

    static int counter = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("SubPanel Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel pane1 = new JPanel();
        JPanel pane2 = new JPanel();

        // Use BorderFactory to create visual borders
        Border b1 = BorderFactory.createLineBorder(Color.RED);
        Border b2 = BorderFactory.createTitledBorder("Sub Panel");

        pane1.setBorder(b1);
        pane2.setBorder(b2);

        addButtons(pane2, 5);
        addButtons(pane1, 2);
        pane1.add(pane2); // Add sub-panel to main panel
        addButtons(pane1, 3);

        frame.add(pane1);
        frame.setVisible(true);
    }

    static void addButtons(JPanel pane, int count) {
        for (int i = 1; i <= count; i++) {
            pane.add(new JButton("Button " + ++counter));
        }
    }
}
