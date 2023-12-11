package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Triangle implements Polygon {
    
    private static final int EDGES = 3;
    
    private final double edge1;
    private final double edge2;
    private final double edge3;

    public Triangle(final double edge) {
        this(edge, edge, edge);
    }

    public Triangle(final double base, final double edges) {
        this(base, edges, edges);
    }

    public Triangle(final double edge1, final double edge2, final double edge3) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
    }

    public double getArea() {
        double AB = this.edge1;
        double BC = this.edge2;
        double AC = this.edge3;
        double semiperimeter = (AB + BC + AC) / 2;

        return Math.sqrt(semiperimeter * (semiperimeter - AB) * (semiperimeter - BC) * (semiperimeter - AC));
    }

    public double getPerimeter() {
        return this.edge1 + this.edge2 + this.edge3;
    }

    public int getEdgeCount() {
        return EDGES;
    }
}
