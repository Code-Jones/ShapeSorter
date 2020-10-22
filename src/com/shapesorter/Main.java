package com.shapesorter;

import com.shapesorter.problemDomain.Shapes;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

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
            populateList(filePath);
        }

    }

    private static void populateList(String filePath) {
        Shapes[] shapesList;
        try {
            FileReader reader = new FileReader(filePath);
            StreamTokenizer token = new StreamTokenizer(reader);
            int currentToken = token.nextToken();
            double length = token.nval;
            System.out.println("length = " + length);
            while (currentToken != StreamTokenizer.TT_EOF) {
                if (token.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println("Current token value : " + token.sval);
                } else {
                    System.out.println("Current token value : " + token.nval);
                }
                currentToken = token.nextToken();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void printHelp() {
        System.out.println("this is in progress");
    }
}

