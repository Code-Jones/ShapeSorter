package com.shapesorter;

import com.shapesorter.utility.Utility;

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

    static char sort;
    static char comparator;
    static boolean pathGiven;
    static boolean sortGiven;
    static boolean compGiven;

    public static void main(String[] args) {
        setFalse();
        String filePath = null;
        // reads all the args and sets state
        if (args.length != 0) {
            for (String arg : args) {
                if (arg.toLowerCase().startsWith("-f")) {
                    filePath = "res/" + arg.substring(2);
                    pathGiven = true;
                    System.out.println(filePath);
                } else if (arg.toLowerCase().startsWith("-t")) {
                    compGiven = true;
                    System.out.println(arg);
                    switch (arg.toLowerCase().substring(2)) {
                        case "h":
                            comparator = 'h';
                            break;
                        case "v":
                            comparator = 'v';
                            break;
                        case "a":
                            comparator = 'a';
                            break;
                        default:
                            printHelp();
                            return;
                    }
                } else if (arg.toLowerCase().startsWith("-s")) {
                    System.out.println(arg);
                    sortGiven = true;
                    switch (arg.toLowerCase().substring(2)) {
                        case "b":
                            sort = 'b';
                            break;
                        case "s":
                            sort = 's';
                            break;
                        case "i":
                            sort = 'i';
                            break;
                        case "m":
                            sort = 'm';
                            break;
                        case "q":
                            sort = 'q';
                            break;
                        case "z":
                            sort = 'z';
                            break;
                        default:
                            printHelp();
                            return;
                    }
                } else printHelp();
            }
            if (pathGiven && sortGiven && compGiven) {
                Utility.sort(comparator, sort, filePath);
            } else setFalse();
        }
    }

    private static void printHelp() {
        System.out.println("this is in progress");
        setFalse();
    }

    private static void setFalse() {
        pathGiven = false;
        sortGiven = false;
        compGiven = false;
    }
}