package com.shapesorter.appDriver;

import com.shapesorter.utility.Utility;

/**
 * @author Matt Jones
 * @version 1
 *
 * Shape sorter. This is a program that shows different sorting algorithms
 * It loads pre-given files and makes shapes out of it. User input then determines
 * the sorting algorithm and the attribute it will be sorted with. go ahead Try it
 */
/*
   Options:
   -t - compare?
   h - height
   v - volume
   a - area
   -s - sort
   b - bubble
   s - selection
   i - insert
   m - merge
   q - quick
   z - thanos
   -f - filePath
   -h - help
    */
public class Main {

    static char sort;
    static char comparator;
    static boolean pathGiven;
    static boolean sortGiven;
    static boolean compGiven;

    /**
     * @param args are above.
     *
     * Takes input from user to set and determine sorting algorithm
     */
    public static void main(String[] args) {
        setFalse();
        String filePath = null;
        // reads all the args and sets state
        if (args.length != 0) {
            for (String arg : args) {
                if (arg.toLowerCase().startsWith("-f")) {
                    filePath = ".\\" + arg.substring(2);
                    // quick fix fixme <-
                    filePath += ".txt";
                    pathGiven = true;
//                    System.out.println(filePath);
                } else if (arg.toLowerCase().startsWith("-t")) {
                    compGiven = true;
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
                } else if (arg.equals(".txt")) {
                    continue; // quick fix
                } else printHelp();
            }
            if (pathGiven && sortGiven && compGiven) {
                Utility.sort(comparator, sort, filePath);
            } else setFalse();
        }
    }


    /**
     * @author Matt Jones
     * Prints the help menu
     * pretty simple
     */
    private static void printHelp() {
        System.out.println("Welcome to the ShapeSorter");
        System.out.println("Please use one of the following commands");
        System.out.println("/n" +
                "   Options:\n" +
                "   -t - compare, match with one of the following\n" +
                "       h - height\n" +
                "       v - volume\n" +
                "       a - area\n" +
                "   -s - sorting pattern, match with the following \n" +
                "          i - insert\n" +
                "          m - merge\n" +
                "          q - quick\n" +
                "          z - thanos\n" +
                "   -f - filePath and write the path\n" +
                "   -h - help\n" );
        System.out.println("example : java -jar .\\ShapeSorter.jar -th -sq -fpolyfor1.txt");
    }


    /**
     * @author Matt Jones
     *
     * just sets these booleans false when input isn't valid
     */
    private static void setFalse() {
        pathGiven = false;
        sortGiven = false;
        compGiven = false;
    }
}