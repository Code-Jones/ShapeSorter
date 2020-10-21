package com.shapesorter;

public class Main {

    // compator obj

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
            System.out.printf("This is the file path given: %s ", filePath);
        }
        
        
    }

    private static void printHelp() {
        System.out.println("this is in progress");
    }
}

