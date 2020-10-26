package com.shapesorter;

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

    private static boolean compare;
    private static boolean pathGiven;
    private static boolean height;
    private static boolean volume;
    private static boolean area;
    private static boolean sort;
    private static boolean bubble;

    public static void main(String[] args) {
        setFalse();
        String filePath = null;
        // reads all the args and sets state
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-t":
                        i++;
                        compare = true;
                        switch (args[i]) {
                            case "h":
                                height = true;
                                break;
                            case "v":
                                volume = true;
                                break;
                            case "a":
                                area = true;
                                break;
                            default:
                                printHelp();
                        }
                        break;
                    case "-f":
                        i++;
                        try {
                            // this is all because we aren't doing -f filepath like normal jars do
                            filePath = args[i];
                            pathGiven = true;
                            break;
                        } catch (Exception e) {
                            printHelp();
                            pathGiven = false;
                            break;
                        }
                    case "-s":
                        i++;
                        sort = true;
                        switch (args[i]) {
                            case "b":
                                bubble = true;
                                break;
                        }
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

        if (pathGiven && compare) {
            if (height) {
                MyArrays.sort('H', filePath);
            } else if (volume) {
                MyArrays.sort('V', filePath);
            } else if (area) {
                MyArrays.sort('B', filePath);
            } else {
                System.out.println("Invalid entry");
                printHelp();
            }
        }
    }

    private static void printHelp() {
        System.out.println("Don't put all your arguments together like an idiot, use this jar how you normally would");
        System.out.println("this is in progress");
        setFalse();
    }

    private static void setFalse() {
        pathGiven = false;
        compare = false;
        height = false;
        volume = false;
        area = false;
    }


}

