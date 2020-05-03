package ru.progwards.java1.lessons.interfaces;

public class ArraySort {

    public static void sort(Comparable<Animal>[] a) {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i].compareTo((Animal) a[j]) == 1)
                {
                    Comparable<Animal> var = a[j];
                    a[j] = a[i];
                    a[i] = var;
                }
            }
        }
    }
}

