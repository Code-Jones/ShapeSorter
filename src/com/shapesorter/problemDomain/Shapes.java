package com.shapesorter.problemDomain;

public abstract class Shapes implements Comparable<Shapes> {
    public double baseArea;
    public double volume;
    public double height;
    public double measurement_2;
    public shapeType type;

    public Shapes(double height, double measurement_2) {
        this.height = height;
        this.measurement_2 = measurement_2;
        this.baseArea = calcBaseArea(height, measurement_2, null);
        this.volume = calcVolume(height, measurement_2, null);
    }
    public Shapes(double height, double measurement_2, shapeType type) {
        this.height = height;
        this.measurement_2 = measurement_2;
        this.type = type;
        this.baseArea = calcBaseArea(height, measurement_2, type);
        this.volume = calcVolume(height, measurement_2, type);
    }

    public double getHeight() {
        return this.height;
    }
    public double getMeasurement_2() {
        return this.measurement_2;
    }


    public abstract double calcBaseArea(double height, double measurement_2, shapeType type);
    public abstract double calcVolume(double height, double measurement_2, shapeType type);

}
