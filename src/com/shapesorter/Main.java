package com.shapesorter;

import com.shapesorter.problemDomain.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Arrays;

//TODO
//      - read jar input
//      - get filePath location
//      - read filePath
//      -
//
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
        boolean running = true;
        boolean compare = false;
        boolean height = false;
        boolean volume = false;
        boolean area = false;
        String filePath = null;
        Shapes[] shapeList;

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

        if (filePath != null) {
            System.out.printf("This is the file path given: %s %n", filePath);
            shapeList = populateList(filePath);
            System.out.println(Arrays.toString(shapeList));
        }

    }

    private static Shapes[] populateList(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            StreamTokenizer token = new StreamTokenizer(reader);
            int currentToken = token.nextToken();

            double length = token.nval;
            Shapes[] shapesList = new Shapes[(int) length];
            int iterator = 0;
            System.out.println("length = " + length);

            currentToken = token.nextToken();
            while (currentToken != StreamTokenizer.TT_EOF) {

                String shape = token.sval;
                currentToken = token.nextToken();
                double measurement_1 = token.nval;
                currentToken = token.nextToken();
                double measurement_2 = token.nval;
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
                            Prisms sqPrism = new Prisms(measurement_1, measurement_2, Prisms.shapeType.SquarePrism);
                            shapesList[iterator] = sqPrism;
                            break;
                        case "TriangularPrism":
                            Prisms triPrism = new Prisms(measurement_1, measurement_2, Prisms.shapeType.TriangularPrism);
                            shapesList[iterator] = triPrism;
                            break;
                        case "OctagonalPrism":
                            Prisms octPrism = new Prisms(measurement_1, measurement_2, Prisms.shapeType.OctagonalPrism);
                            shapesList[iterator] = octPrism;
                            break;
                        case "PentagonalPrism":
                            Prisms pentPrism = new Prisms(measurement_1, measurement_2, Prisms.shapeType.PentagonalPrism);
                            shapesList[iterator] = pentPrism;
                            break;
                    }
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

