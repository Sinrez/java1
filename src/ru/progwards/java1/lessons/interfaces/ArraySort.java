package ru.progwards.java1.lessons.interfaces;

import java.lang.reflect.Array;
import java.util.Arrays;

import ru.progwards.java1.lessons.interfaces.CompareWeight.CompareResult;

public class ArraySort {

    public static void sort(CompareWeight [] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i].compareWeight((Animal) a[j]) == CompareResult.GREATER)
                {
                    CompareWeight n = a[j];
                    a[j] = a[i];
                    a[i] = n;
                }
            }
        }
    }
}