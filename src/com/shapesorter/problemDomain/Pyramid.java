package com.shapesorter.problemDomain;

public class Pyramid extends Shapes {
//    public double height;
//    public double edgeLength;

    public Pyramid(double height, double edgeLength) {
        super(height, edgeLength);
//        this.height = height;
//        this.edgeLength = edgeLength;
    }

    @Override
    public double calcBaseArea(double height, double edgeLength, shapeType type) {
        return edgeLength * edgeLength;
    }

    @Override
    public double calcVolume(double height, double edgeLength, shapeType type) {
        return (1.0 / 3.0) * Math.pow(edgeLength, 2) * height;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "baseArea=" + baseArea +
                ", volume=" + volume +
                ", height=" + measurement_1 +
                ", edge=" + measurement_2 +
                '}';
    }
}
