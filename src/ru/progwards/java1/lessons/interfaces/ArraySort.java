package ru.progwards.java1.lessons.interfaces;

public class ArraySort {
    public static void sort(Comparable<Animal>[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                Comparable<Animal> n;
                if (a[i].compareTo((Animal)a[j]) == 1 ) {
                    n = a[i];
                    a[i] = a[j];
                    a[j] = n;
                }
            }
        }
    }
}