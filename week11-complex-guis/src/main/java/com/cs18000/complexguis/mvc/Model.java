package com.cs18000.complexguis.mvc;

/**
 * Model class for MVC pattern demonstration.
 * Stores data for drawing a shape (position and size).
 *
 * Based on Week 11 lecture slides - page 78
 */
public class Model {
    private int x;
    private int y;
    private int width;
    private int height;

    public Model(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
