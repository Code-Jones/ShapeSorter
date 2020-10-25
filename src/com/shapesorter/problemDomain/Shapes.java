package com.shapesorter.problemDomain;


import java.util.Comparator;

public abstract class Shapes implements Comparable {
    public double baseArea;
    public double volume;
    public double measurement_1;
    public double measurement_2;
    public shapeType type;

    public Shapes(double measurement_1, double measurement_2) {
        this.measurement_1 = measurement_1;
        this.measurement_2 = measurement_2;
        this.baseArea = calcBaseArea(measurement_1, measurement_2, null);
        this.volume = calcVolume(measurement_1, measurement_2, null);
    }
    public Shapes(double measurement_1, double measurement_2, shapeType type) {
        this.measurement_1 = measurement_1;
        this.measurement_2 = measurement_2;
        this.type = type;
        this.baseArea = calcBaseArea(measurement_1, measurement_2, type);
        this.volume = calcVolume(measurement_1, measurement_2, type);
    }

    public double getHeight() {
        return this.measurement_1;
    }
    public double getMeasurement_2() {
        return this.measurement_2;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    public abstract double calcBaseArea(double measurement_1, double measurement_2, shapeType type);
    public abstract double calcVolume(double measurement_1, double measurement_2, shapeType type);

}
