package com.shapesorter;

import com.shapesorter.problemDomain.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Comparator;

public class MyArrays {

    public static void sort(char sortAlgorithm, String filePath) {
        BaseAreaComparator bac = new BaseAreaComparator();
        Comparable[] fuck = populateList(filePath);
        // fixme do this
        if (sortAlgorithm == 'B') {
            bubbleSort(fuck, bac);
        }
    }

    private static void bubbleSort(Comparable[] items, Comparator comparator) {
        System.out.println("should bubble sort now");
        Comparable temp;
        for (int i = 0; i < items.length; i++) {
            for (int j = 1; j < (items.length - i); j++) {
                if (comparator.compare(items[j - 1], items[j]) > 0) {
                    temp = items[j - 1];
                    items[j - 1] = items[j];
                    items[j] = temp;
                }
            }
        }
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
            return (int) (o1.baseArea - o2.baseArea);
        }
    }

    public static class VolumeComparator implements Comparator<Shapes> {

        @Override
        public int compare(Shapes o1, Shapes o2) {
            return (int) (o1.volume - o2.volume);
        }
    }
}