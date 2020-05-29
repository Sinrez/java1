package ru.progwards.java1.lessons.interfaces;

import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class ArraySort implements Comparable<CompareWeight> {


    public static void sort(CompareWeight[] a) {
        Comparable tmpValue;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].getWeight() > a[i].getWeight()) {
                    tmpValue = (Comparable) a[i];
                    a[i] = a[j];
                    a[j] = (CompareWeight) tmpValue;
                }
            }
        }
    }
}
