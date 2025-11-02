package com.cs18000.complexguis.events;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Demonstrates using Anonymous Inner Classes for event handling.
 * This is a common and concise way to attach event handlers.
 *
 * Based on Week 11 lecture slides - pages 46-47
 */
public class AnonymousInnerClassDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("Anonymous Inner Class Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 150);

        JPanel panel = new JPanel(new FlowLayout());

        // Example 1: Anonymous inner class for button 1
        JButton button1 = new JButton("Click Me (Anonymous)");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Button 1 pressed: " + ae.getActionCommand());
                button1.setText("Clicked!");
            }
        });

        // Example 2: Another anonymous inner class
        JButton button2 = new JButton("Show Message");
        button2.addActionListener(new ActionListener() {
            private int clickCount = 0;

            public void actionPerformed(ActionEvent ae) {
                clickCount++;
                System.out.println("Button 2 clicked " + clickCount + " times");
                button2.setText("Clicks: " + clickCount);
            }
        });

        // Example 3: Close button
        JButton closeButton = new JButton("Close Window");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Closing window...");
                frame.dispose();
            }
        });

        panel.add(button1);
        panel.add(button2);
        panel.add(closeButton);

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
