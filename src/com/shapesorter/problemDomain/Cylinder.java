package com.shapesorter.problemDomain;

public class Cylinder extends Shapes {

    public Cylinder(double height, double radius) {
        super(height, radius);
    }

    @Override
    public double calcBaseArea(double height, double radius, shapeType type) {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calcVolume(double height, double radius, shapeType type) {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "baseArea=" + baseArea +
                ", volume=" + volume +
                ", height=" + height +
                ", radius=" + measurement_2 +
                '}';
    }


    @Override
    public int compareTo(Shapes shape) {
        if (shape.getHeight() == this.height) {
            return 0;
        } else if (shape.getHeight() >= this.height){
            return 1;
        } else return -1;
    }
}
