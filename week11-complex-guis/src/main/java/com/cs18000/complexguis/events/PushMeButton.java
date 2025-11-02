package com.cs18000.complexguis.events;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Demonstrates event handling with ActionListener interface.
 * Button changes text after first click and closes window after second click.
 *
 * Based on Week 11 lecture slides - pages 35-40
 */
public class PushMeButton implements ActionListener {
    static JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        frame = new JFrame("Push Me");
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton button = centeredButton();
        button.addActionListener(new PushMeButton());

        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Center on screen
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        if (b.getActionCommand().equals("last time")) {
            frame.dispose();
        }

        if (b.getActionCommand().equals("push")) {
            b.setActionCommand("last time");
            b.setText("Push Again");
        }
    }

    static JButton centeredButton() {
        // Add empty labels to achieve centering with BorderLayout
        String[] location = { BorderLayout.NORTH, BorderLayout.EAST,
                              BorderLayout.SOUTH, BorderLayout.WEST };

        for (String s : location) {
            frame.add(new JLabel("  "), s);
        }

        JButton jb = new JButton("Push Me");
        jb.setActionCommand("push");
        frame.add(jb);
        return jb;
    }
}
