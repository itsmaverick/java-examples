package com.cs18000.complexguis.mvc;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * View class for MVC pattern demonstration.
 * Draws a shape based on data from the Model.
 *
 * Based on Week 11 lecture slides - pages 76-78
 */
public class View extends JComponent {
    private Model model;

    public View(Model model) {
        this.model = model;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw based on model data
        g2.setColor(Color.BLUE);
        g2.fillRect(model.getX(), model.getY(),
                    model.getWidth(), model.getHeight());

        // Add some text
        g2.setColor(Color.BLACK);
        g2.drawString("MVC Pattern Demo", 10, 20);
        g2.drawString("Rectangle at (" + model.getX() + ", " + model.getY() + ")", 10, 40);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
        repaint(); // Repaint when model changes
    }
}
