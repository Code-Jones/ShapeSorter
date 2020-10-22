package com.shapesorter.problemDomain;

public class Pyramid extends Shapes{
    public double height;
    public double edgeLength;

    public Pyramid(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double calcBaseArea() {
        return edgeLength * edgeLength;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3.0) * Math.pow(edgeLength, 2) * height;
    }
}
