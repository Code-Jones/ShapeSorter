package com.shapesorter.problemDomain;

/**
 * @author Matt Jones
 * @version 1
 *
 * This is the abstract class which all the shapes are based after.
 * The second constructor is only for Prisms since there are many different prisms
 */
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

    public abstract double calcBaseArea(double height, double measurement_2, shapeType type);
    public abstract double calcVolume(double height, double measurement_2, shapeType type);

}
