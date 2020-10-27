package com.shapesorter.problemDomain;

public class Cone extends Shapes {

    public Cone(double height, double radius) {
        super(height, radius);
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
