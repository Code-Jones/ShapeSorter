package com.shapesorter.problemDomain;

public class Cone extends Shapes {
//    public double height;
//    public double radius;

    public Cone(double height, double radius) {
        super(height, radius);
//        this.height = height;
//        this.radius = radius;
    }

    @Override
    public double calcBaseArea(double height, double radius, shapeType type) {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calcVolume(double height, double radius, shapeType type) {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }


    @Override
    public String toString() {
        return "Cone{" +
                "baseArea=" + baseArea +
                ", volume=" + volume +
                ", height=" + measurement_1 +
                ", radius=" + measurement_2 +
                '}';
    }
}
