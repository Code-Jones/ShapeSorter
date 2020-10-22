package com.shapesorter.problemDomain;

public class Cylinder extends Shapes {
    public double height;
    public double radius;

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calcVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

}
