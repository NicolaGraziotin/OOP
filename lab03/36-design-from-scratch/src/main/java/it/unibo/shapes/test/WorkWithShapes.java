package it.unibo.shapes.test;

import it.unibo.shapes.api.Polygon;
import it.unibo.shapes.api.Shape;
import it.unibo.shapes.impl.Circle;
import it.unibo.shapes.impl.Rectangle;
import it.unibo.shapes.impl.Square;
import it.unibo.shapes.impl.Triangle;

public class WorkWithShapes {

    public WorkWithShapes() { }

    public static void main(String[] args) {

        final Shape circle = new Circle(1);
        final Polygon square = new Square(2);
        final Polygon rectangle = new Rectangle(3, 4);
        final Polygon equilateralTriangle = new Triangle(5);
        final Polygon isoscelesTriangle = new Triangle(6, 7);
        final Polygon scaleneTriangle = new Triangle(8, 9, 10);

        System.out.println(circle.getClass().getSimpleName() + " area= " + circle.getArea() + " perimeter= " + circle.getPerimeter());
        System.out.println(square.getClass().getSimpleName() + " area= " + square.getArea() + " perimeter= " + square.getPerimeter());
        System.out.println(rectangle.getClass().getSimpleName() + " area= " + rectangle.getArea() + " perimeter= " + rectangle.getPerimeter());
        System.out.println(equilateralTriangle.getClass().getSimpleName() + " area= " + equilateralTriangle.getArea() + " perimeter= " + equilateralTriangle.getPerimeter());
        System.out.println(isoscelesTriangle.getClass().getSimpleName() + " area= " + isoscelesTriangle.getArea() + " perimeter= " + isoscelesTriangle.getPerimeter());
        System.out.println(scaleneTriangle.getClass().getSimpleName() + " area= " + scaleneTriangle.getArea() + " perimeter= " + scaleneTriangle.getPerimeter());
    }
}
