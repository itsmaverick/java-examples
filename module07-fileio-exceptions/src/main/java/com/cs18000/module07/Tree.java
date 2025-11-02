package com.cs18000.module07;

import java.io.Serializable;

/**
 * Example class for Object I/O demonstration
 * Must implement Serializable to be written to/read from files
 */
public class Tree implements Serializable {
    private static final long serialVersionUID = 1L;

    private double circumference;
    private String species;

    public Tree(double circumference, String species) {
        this.circumference = circumference;
        this.species = species;
    }

    public double getCircumference() {
        return circumference;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return String.format("%x: circumference = %.1f, species = %s",
                hashCode(), circumference, species);
    }
}
