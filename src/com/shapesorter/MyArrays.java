package com.shapesorter;

import com.shapesorter.problemDomain.Shapes;

import java.util.Comparator;

public class MyArrays {

    public static void sort(Comparable[] shapes, char sortAlgorithm, Comparator<Shapes> comparator) {
        // fixme do this
        if (sortAlgorithm == 'B') {
            bubbleSort(shapes, comparator);
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