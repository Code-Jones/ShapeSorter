package com.shapesorter.problemDomain;

public class Pyramid extends Shapes {

    public Pyramid(double height, double edgeLength) {
        super(height, edgeLength);
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
                ", height=" + height +
                ", edge=" + measurement_2 +
                '}';
    }

    @Override
    public int compareTo(Shapes shape) {
        if (shape.getHeight() == getHeight()) {
            return 0;
        } else if (shape.getHeight() >= this.height){
            return 1;
        } else return -1;
    }
}
