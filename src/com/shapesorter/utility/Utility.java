package com.shapesorter.utility;

import com.shapesorter.problemDomain.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Comparator;

public class Utility {

    public static void sort(char comparator, char sort, String filePath) {
        Shapes[] shapes = populateList(filePath);
        VolumeComparator vc = new VolumeComparator();
        BaseAreaComparator bac = new BaseAreaComparator();
        // just minimize this, you know what it does...
        switch (sort) {
            case 'b':
                switch (comparator) {
                    case 'a':
                        bubbleSort(shapes, bac, false);
                        break;
                    case 'v':
                        bubbleSort(shapes, vc, false);
                        break;
                    case 'h':
                        bubbleSort(shapes, vc, true);
                        break;
                }
                break;
            case 's':
                switch (comparator) {
                    case 'a':
                        selectionSort(shapes, bac, false);
                        break;
                    case 'v':
                        selectionSort(shapes, vc, false);
                        break;
                    case 'h':
                        selectionSort(shapes, vc, true);
                        break;
                }
                break;
            case 'i':
                switch (comparator) {
                    case 'a':
                        insertionSort(shapes, bac, false);
                        break;
                    case 'v':
                        insertionSort(shapes, vc, false);
                        break;
                    case 'h':
                        insertionSort(shapes, vc, true);
                        break;
                }
                break;
            case 'm':
                switch (comparator) {
                    case 'a':
                        mergeSort(shapes, bac, false);
                        break;
                    case 'v':
                        mergeSort(shapes, vc, false);
                        break;
                    case 'h':
                        mergeSort(shapes, vc, true);
                        break;
                }
                break;
            case 'q':
                switch (comparator) {
                    case 'a':
                        quickSort(shapes, bac, false);
                        break;
                    case 'v':
                        quickSort(shapes, vc, false);
                        break;
                    case 'h':
                        quickSort(shapes, vc, true);
                        break;
                }
                break;
            case 'z':
                switch (comparator) {
                    case 'a':
                        myChoiceSort(shapes, bac, false);
                        break;
                    case 'v':
                        myChoiceSort(shapes, vc, false);
                        break;
                    case 'h':
                        myChoiceSort(shapes, vc, true);
                        break;
                }
                break;
        }
    }

    private static void bubbleSort(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
        System.out.println("should bubble sort now");
        long time = System.currentTimeMillis();
        if (height) System.out.printf("First shape height : %.2f %n", shapes[0].height);
        else {
            System.out.printf("First shape base area : %.2f %n", shapes[0].baseArea);
        }
        Shapes temp;
        for (int i = 0; i < shapes.length; i++) {
            for (int j = 1; j < (shapes.length - i); j++) {
                if (height) {
                    if (shapes[j - 1].compareTo(shapes[j]) > 0) {
                        temp = shapes[j - 1];
                        shapes[j - 1] = shapes[j];
                        shapes[j] = temp;
                    }
                } else {
                    if (comparator.compare(shapes[j - 1], shapes[j]) > 0) {
                        temp = shapes[j - 1];
                        shapes[j - 1] = shapes[j];
                        shapes[j] = temp;
                    }
                }
            }
        }
        System.out.printf("Bubble sort took : %.2f %n", (double) (System.currentTimeMillis() - time));
        for (int i = 0; i < shapes.length; i++) {
            if (i % 1000 == 0) {
                System.out.printf("Hopefully this is sorted : %.2f %n", shapes[i].height);
            }
        }
        System.out.printf("Last shape : %.2f %n", height ? shapes[shapes.length - 1].height : shapes[shapes.length - 1].baseArea);

    }

    private static void selectionSort(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
    }

    private static void insertionSort(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
    }

    private static void mergeSort(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
    }

    private static void quickSort(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
    }

    private static void myChoiceSort(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
    }

    /**
     * Populates a shapes list with the filePath given
     * If it's not a correct path, throws error.
     *
     * @param filePath, file path
     * @return shapes array
     */
    private static Shapes[] populateList(String filePath) {
        // todo add .\ to file path if it isn't there
        try {
            FileReader reader = new FileReader(filePath);
            StreamTokenizer token = new StreamTokenizer(reader);
            // set the first token for the length of the array
            int currentToken = token.nextToken();

            double length = token.nval;
            Shapes[] shapesList = new Shapes[(int) length];
            int iterator = 0;
            System.out.println("length = " + length);

            // move it to the second token in the text, first object to be read
            currentToken = token.nextToken();
            while (currentToken != StreamTokenizer.TT_EOF) {
                // get the 3 details of any object
                String shape = token.sval;
                currentToken = token.nextToken();
                double measurement_1 = token.nval;
                currentToken = token.nextToken();
                double measurement_2 = token.nval;
                // put it the right object
                switch (shape) {
                    case "Cone":
                        Cone cone = new Cone(measurement_1, measurement_2);
                        shapesList[iterator] = cone;
                        break;
                    case "Cylinder":
                        Cylinder cylinder = new Cylinder(measurement_1, measurement_2);
                        shapesList[iterator] = cylinder;
                        break;
                    case "Pyramid":
                        Pyramid pyramid = new Pyramid(measurement_1, measurement_2);
                        shapesList[iterator] = pyramid;
                        break;
                    case "SquarePrism":
                        Prisms sqPrism = new Prisms(measurement_1, measurement_2, shapeType.SquarePrism);
                        shapesList[iterator] = sqPrism;
                        break;
                    case "TriangularPrism":
                        Prisms triPrism = new Prisms(measurement_1, measurement_2, shapeType.TriangularPrism);
                        shapesList[iterator] = triPrism;
                        break;
                    case "OctagonalPrism":
                        Prisms octPrism = new Prisms(measurement_1, measurement_2, shapeType.OctagonalPrism);
                        shapesList[iterator] = octPrism;
                        break;
                    case "PentagonalPrism":
                        Prisms pentPrism = new Prisms(measurement_1, measurement_2, shapeType.PentagonalPrism);
                        shapesList[iterator] = pentPrism;
                        break;
                }
                // move the token to the next object name
                // do at the end so you can see if end of file or not
                currentToken = token.nextToken();
                iterator++;
            }
            return shapesList;
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return new Shapes[0];
    }

    public static class BaseAreaComparator implements Comparator<Shapes> {

        @Override
        public int compare(Shapes o1, Shapes o2) {
            if (o1.baseArea == o2.baseArea) {
                return 0;
            } else if (o1.baseArea >= o2.baseArea) {
                return 1;
            } else return -1;
        }

    }

    public static class VolumeComparator implements Comparator<Shapes> {

        @Override
        public int compare(Shapes o1, Shapes o2) {
            if (o1.baseArea == o2.baseArea) {
                return 0;
            } else if (o1.baseArea >= o2.baseArea) {
                return 1;
            } else return -1;
        }
    }
}