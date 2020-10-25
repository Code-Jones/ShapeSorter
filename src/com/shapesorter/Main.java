package com.shapesorter;

import com.shapesorter.problemDomain.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

/*
   Options:
   -t - compare?
   h - height
   v - volume
   a - area
   -f - filePath
   -h - help
    */
public class Main {

    public static void main(String[] args) {
        boolean pathgiven;
        boolean running = true;
        boolean compare = false;
        boolean height = false;
        boolean volume = false;
        boolean area = false;
        String filePath = null;
        Shapes[] shapeList;
        Comparable[] fuck;

        // reads all the args and sets state
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-t":
                        compare = true;
                        break;
                    case "h":
                        height = true;
                        break;
                    case "v":
                        volume = true;
                        break;
                    case "a":
                        area = true;
                        break;
                    case "-f":
                        pathgiven = true;
                        ++i;
                        filePath = args[i];
                        break;
                    case "-h":
                        printHelp();
                        return;
                    default:
                        System.out.println("Unknown argument: " + args[i]);
                        return;
                }
            }
        } else printHelp();

        // for building default compare
//        shapeList = populateList(filePath);
        fuck = populateList(filePath);


        if (compare && area) {

            MyArrays.BaseAreaComparator bac = new MyArrays.BaseAreaComparator();
            MyArrays.sort(fuck, 'B', bac);

            System.out.println(Arrays.toString(fuck));
//            System.out.println(shapeList[0].toString() + " : " + shapeList[1].toString());
//            System.out.println(shapeList[0].baseArea + " : " + shapeList[1].baseArea);
//            System.out.println(bac.compare(shapeList[0], shapeList[1]));
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

    private static void printHelp() {
        System.out.println("this is in progress");
    }


}

