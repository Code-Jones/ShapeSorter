package com.shapesorter.problemDomain;

public class Prisms extends Shapes {
    public shapeType type;


    public Prisms(double height, double edge, shapeType type) {
        super(height, edge, type);
    }

    @Override
    public double calcBaseArea(double height, double edge, shapeType type) {
        switch (type) {
            case SquarePrism:
                return Math.pow(edge, 2);
            case TriangularPrism:
                return (Math.pow(edge, 2) * Math.sqrt(3)) / 4;
            case PentagonalPrism:
                return (5 * Math.pow(edge, 2) * Math.tan(54)) / 4;
            case OctagonalPrism:
                return 2 * (1 + Math.sqrt(2)) * Math.pow(edge, 2);
            default:
                System.out.println("Something weird happened causing base area to not be assigned a type");
                return 0;
        }
    }

    @Override
    public double calcVolume(double height, double edge, shapeType type) {
        switch (type) {
            case SquarePrism:
                return Math.pow(edge, 2) * height;
            case TriangularPrism:
            case PentagonalPrism:
            case OctagonalPrism:
                return calcBaseArea(height, edge, type) * height;
            default:
                System.out.println("Something weird happened causing volume to not be assigned a type");
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Prisms{" +
                "baseArea=" + baseArea +
                ", volume=" + volume +
                ", height=" + height +
                ", measurement_2=" + measurement_2 +
                ", type=" + type +
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
