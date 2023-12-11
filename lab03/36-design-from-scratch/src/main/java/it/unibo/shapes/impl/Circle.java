package it.unibo.shapes.impl;

import it.unibo.shapes.api.Shape;

public class Circle implements Shape {

    private final double radius;

    public Circle(final double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getPerimeter() {
        return 2 * this.radius * Math.PI;
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }
}