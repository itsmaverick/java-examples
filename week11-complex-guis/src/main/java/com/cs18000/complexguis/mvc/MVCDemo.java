package com.cs18000.complexguis.mvc;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Demonstrates the Model-View-Controller pattern.
 * The Model stores data, the View displays it, and the Controller
 * (buttons/event handlers) modifies the Model.
 *
 * Based on Week 11 lecture slides - pages 76-79
 */
public class MVCDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("MVC Pattern Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);

        // Create Model
        Model model = new Model(100, 100, 150, 100);

        // Create View
        View view = new View(model);

        // Create Controller (buttons)
        JPanel controlPanel = new JPanel();

        JButton moveRightButton = new JButton("Move Right");
        moveRightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setX(model.getX() + 10);
                view.repaint();
            }
        });

        JButton moveDownButton = new JButton("Move Down");
        moveDownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setY(model.getY() + 10);
                view.repaint();
            }
        });

        JButton growButton = new JButton("Grow");
        growButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setWidth(model.getWidth() + 10);
                model.setHeight(model.getHeight() + 10);
                view.repaint();
            }
        });

        JButton shrinkButton = new JButton("Shrink");
        shrinkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (model.getWidth() > 20 && model.getHeight() > 20) {
                    model.setWidth(model.getWidth() - 10);
                    model.setHeight(model.getHeight() - 10);
                    view.repaint();
                }
            }
        });

        controlPanel.add(moveRightButton);
        controlPanel.add(moveDownButton);
        controlPanel.add(growButton);
        controlPanel.add(shrinkButton);

        frame.add(view, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
