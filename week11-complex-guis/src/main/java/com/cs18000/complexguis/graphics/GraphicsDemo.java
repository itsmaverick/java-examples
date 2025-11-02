package com.cs18000.complexguis.graphics;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * Demonstrates using Graphics2D to draw shapes and text on a JComponent.
 * Shows basic drawing operations: lines, rectangles, ovals, and text.
 *
 * Based on Week 11 lecture slides - pages 71-75
 */
public class GraphicsDemo extends JComponent {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("Graphics2D Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);

        GraphicsDemo demo = new GraphicsDemo();
        frame.add(demo);

        frame.setVisible(true);
    }

    /**
     * The paintComponent method is called on the EDT in response to a call
     * to repaint().
     */
    @Override
    public void paintComponent(Graphics g) {
        // Cast to Graphics2D for extended API
        Graphics2D g2 = (Graphics2D) g;

        // Draw a line
        g2.setColor(Color.BLACK);
        g2.drawLine(50, 50, 200, 150);

        // Draw a rectangle (outline)
        g2.setColor(Color.BLUE);
        g2.drawRect(250, 50, 150, 100);

        // Fill a rectangle
        g2.setColor(Color.GREEN);
        g2.fillRect(450, 50, 100, 80);

        // Draw an oval (outline)
        g2.setColor(Color.ORANGE);
        g2.drawOval(50, 200, 120, 120);

        // Fill an oval
        g2.setColor(Color.RED);
        g2.fillOval(220, 200, 120, 120);

        // Draw text
        g2.setColor(Color.BLACK);
        g2.drawString("Hello Graphics2D!", 400, 250);

        // Draw more complex shapes
        g2.setColor(Color.MAGENTA);
        g2.drawLine(50, 350, 150, 350);
        g2.drawRect(180, 320, 80, 60);
        g2.setColor(Color.CYAN);
        g2.fillOval(280, 320, 80, 60);
    }
}
