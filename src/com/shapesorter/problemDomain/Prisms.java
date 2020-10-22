package com.shapesorter.problemDomain;

public class Prisms extends Shapes {
    public double height;
    public double edge;
    public shapeType type;
    public enum shapeType {
        SquarePrism,
        TriangularPrism,
        PentagonalPrism,
        OctagonalPrism
    }

    public Prisms(double height, double edge, shapeType type) {
        this.height = height;
        this.edge = edge;
        this.type = type;
    }

    @Override
    public double calcBaseArea() {
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
    public double calcVolume() {
        switch (type) {
            case SquarePrism:
                return Math.pow(edge, 2) * height;
            case TriangularPrism:
            case PentagonalPrism:
            case OctagonalPrism:
                return calcBaseArea() * height;
            default:
                System.out.println("Something weird happened causing volume to not be assigned a type");
                return 0;
        }
    }

}
