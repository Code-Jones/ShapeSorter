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
        System.out.println("Bubble sort will start now");
        long time = System.nanoTime();

        // sort time
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
                    if (comparator.compare(shapes[j - 1], shapes[j]) < 0) {
                        temp = shapes[j - 1];
                        shapes[j - 1] = shapes[j];
                        shapes[j] = temp;
                    }
                }
            }
        }
        // printing stuff
        double endTime = (double) (System.nanoTime() - time) / 1000;
        System.out.printf("Bubble sort took : %.2f milliseconds %n", endTime);
        printInfo(shapes, comparator, height);
    }

    private static void selectionSort(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
        System.out.println("Selection sort will start now");
        long time = System.nanoTime();

        // sort time
        int small;
        for (int i = 0; i < shapes.length - 1; i++) {
            Shapes lowest = shapes[i];
            int lowestIndex = i;
            for (int j = i; j < shapes.length; j++) {
                if (height) {
                    if (shapes[j].compareTo(lowest) < 0) {
                        lowest = shapes[j];
                        lowestIndex = j;
                    }
                } else {
                    if (comparator.compare(shapes[j], lowest) > 0) {
                        lowest = shapes[j];
                        lowestIndex = j;
                    }
                }
            }
            //Swap
            if (i != lowestIndex) {
                Shapes temp = shapes[i];
                shapes[i] = shapes[lowestIndex];
                shapes[lowestIndex] = temp;
            }
        }
        // printing stuff
        double endTime = (double) (System.nanoTime() - time) / 1000;
        System.out.printf("Selection sort took : %.2f milliseconds %n", endTime);
        printInfo(shapes, comparator, height);
    }

    private static void insertionSort(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
        System.out.println("Insertion sort will start now");
        long time = System.nanoTime();

        // sort time
        for (int i = 1; i < shapes.length; i++) {
            Shapes key = shapes[i];
            int j = i - 1;
            //shift until you find the position to place the element 'key'
            if (height) {
                while (j >= 0 && shapes[j].compareTo(key) > 0) {
                    shapes[j + 1] = shapes[j];
                    j--;
                }
            } else {
                while (j >= 0 && comparator.compare(shapes[j], key) < 0) {
                    shapes[j + 1] = shapes[j];
                    j--;
                }
            }
            //place element 'key' in the correct position in the sorted part of the array
            shapes[j + 1] = key;
        }
        // printing stuff
        double endTime = (double) (System.nanoTime() - time) / 1000;
        System.out.printf("Insertion sort took : %.2f milliseconds %n", endTime);
        printInfo(shapes, comparator, height);
    }

    private static void mergeSort(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
        System.out.println("Merge sort will start now");
        long time = System.nanoTime();

        // sort time
        // uses recursion so in the method it goes
        innerMergeSort(shapes, shapes.length, comparator, height);

        // printing stuff
        double endTime = (double) (System.nanoTime() - time) / 1000;
        System.out.printf("Merge sort took : %.2f milliseconds %n", endTime);
        printInfo(shapes, comparator, height);
    }

    public static void innerMergeSort(Shapes[] all, int size, Comparator<Shapes> comparator, boolean height) {
        if (size < 2) {
            return;
        }
        int mid = size / 2;
        Shapes[] left = new Shapes[mid];
        Shapes[] right = new Shapes[size - mid];

        System.arraycopy(all, 0, left, 0, mid);
        if (size - mid >= 0) System.arraycopy(all, mid, right, mid - mid, size - mid);

        innerMergeSort(left, mid, comparator, height);
        innerMergeSort(right, size - mid, comparator, height);

        merge(all, left, right, mid, size - mid, comparator, height);

    }

    public static void merge(Shapes[] all, Shapes[] leftList, Shapes[] rightList, int left, int right, Comparator<Shapes> comparator, boolean height) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (height) {
                if (leftList[i].compareTo(rightList[j]) < 0) {
                    all[k++] = leftList[i++];
                } else {
                    all[k++] = rightList[j++];
                }
            } else {
                if (comparator.compare(leftList[i], rightList[j]) > 0) {
                    all[k++] = leftList[i++];
                } else {
                    all[k++] = rightList[j++];
                }
            }
        }
        while (i < left) {
            all[k++] = leftList[i++];
        }
        while (j < right) {
            all[k++] = rightList[j++];
        }
    }

    private static void quickSort(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
        System.out.println("Quick sort will start now");
        long time = System.nanoTime();

        // sort time
        // uses recursion so in the method it goes
        innerQuickSort(0, shapes.length - 1, shapes, comparator, height);

        // printing stuff
        double endTime = (double) (System.nanoTime() - time) / 1000;
        System.out.printf("Quick sort took : %.2f milliseconds %n", endTime);
        printInfo(shapes, comparator, height);
    }

    private static void innerQuickSort(int left, int right, Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
        if (left < right) {
            int p = part(shapes, comparator, left, right, height);
            innerQuickSort(left, p - 1, shapes, comparator, height);
            innerQuickSort(p + 1, right, shapes, comparator, height);
        }
    }

    private static int part(Shapes[] shapes, Comparator<Shapes> comparator, int left, int right, boolean height) {
        Shapes piv = shapes[left];
        int p = left;

        for (int r = left; r < right; r++) {
            int comp;
            if (height) {
                comp = shapes[r].compareTo(piv);
            } else {
                comp = comparator.compare(shapes[r], piv);
            }
            if (comp > 0) {
                shapes[p] = shapes[r];
                shapes[r] = shapes[p + 1];
                shapes[p + 1] = piv;
                p++;
            }
        }
        return p;
    }

    private static void myChoiceSort(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
        System.out.println("Insertion sort will start now");
        long time = System.nanoTime();


        // sort time
        int i = 0;
        for (int j = 1; j < shapes.length; i++, j++) {
            if (shapes2[i] > shapes2[j]) {
                i--;
            } else {
                if (j - i > 1) {
                    array[i + 1] = array[j];
                }
            }
        }

        // printing stuff
        double endTime = (double) (System.nanoTime() - time) / 1000;
        System.out.printf("Quick sort took : %.2f milliseconds %n", endTime);
        printInfo(shapes, comparator, height);
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
            System.out.printf("There are %.0f shapes in the file loaded%n", length);

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

    private static void printInfo(Shapes[] shapes, Comparator<Shapes> comparator, boolean height) {
        if (height) {
            System.out.printf("The biggest shape's height is: %.2f %n", shapes[0].height);
            for (int i = 1; i < shapes.length; i++) {
                if (i % 1000 == 0) {
                    System.out.printf("Number %d shape's height is: %.2f %n", i, shapes[i].height);
                }
            }
            System.out.printf("The smallest shape's height is: %.2f %n", shapes[shapes.length - 1].height);
        } else if (comparator.toString().equals("BaseAreaComparator")) {
            System.out.printf("The biggest shape's base area is: %.2f %n", shapes[0].baseArea);
            for (int i = 1; i < shapes.length; i++) {
                if (i % 1000 == 0) {
                    System.out.printf("Number %d shape's base area is: %.2f %n", i, shapes[i].baseArea);
                }
            }
            System.out.printf("The smallest shape's base area is: %.2f %n", shapes[shapes.length - 1].baseArea);
        } else {
            System.out.printf("The biggest shape's volume is: %.2f %n", shapes[0].volume);
            for (int i = 1; i < shapes.length; i++) {
                if (i % 1000 == 0) {
                    System.out.printf("Number %d shape's volume is: %.2f %n", i, shapes[i].volume);
                }
            }
            System.out.printf("The smallest shape's volume is: %.2f %n", shapes[shapes.length - 1].volume);
        }
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

        @Override
        public String toString() {
            return "BaseAreaComparator";
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

        @Override
        public String toString() {
            return "VolumeComparator";
        }
    }
}