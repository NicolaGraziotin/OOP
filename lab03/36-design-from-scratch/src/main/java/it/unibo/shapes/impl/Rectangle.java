package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Rectangle implements Polygon {
    
    private static final int BASE_COUNT = 2;
    private static final int HEIGHT_COUNT = 2;

    private final double base;
    private final double height;

    public Rectangle(final double base, final double height) {
        this.base = base;
        this.height = height;
    }

    public double getPerimeter() {
        return this.base*BASE_COUNT + this.height*HEIGHT_COUNT;
    }

    public double getArea() {
        return this.base*this.height;
    }

    public int getEdgeCount() {
        return BASE_COUNT+HEIGHT_COUNT;
    }
}
