package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Square implements Polygon {
    
    private static final int EDGE_COUNT = 4;

    private final double edge;

    public Square(final double edge) {
        this.edge = edge;
    }

    public double getPerimeter() {
        return this.edge * EDGE_COUNT;
    }

    public double getArea() {
        return Math.pow(this.edge, 2);
    }

    public int getEdgeCount() {
        return EDGE_COUNT;
    }
}
