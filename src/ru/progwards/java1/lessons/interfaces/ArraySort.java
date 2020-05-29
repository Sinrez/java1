package ru.progwards.java1.lessons.interfaces;

public class ArraySort {

    public static void sort(Comparable<Animal>[] a) {
        Comparable tmpValue;
        for (int i = a.length - 1; i >= 0; i--) {
            // найдем в остатках максимальный
            for (int j = 0; j < i; j++) {
                //if (a[j].compareTo(a[i]) > 0) {
                if (a[j].compareTo((Animal) a[i]) > 0) {
                    tmpValue = a[i];
                    a[i] = a[j];
                    a[j] = tmpValue;
                }
            }
        }
    }


    public static void main(String[] args) {
    }

}