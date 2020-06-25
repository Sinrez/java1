package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Creator {
    //  создать коллекцию и заполнить последовательностью четных возрастающих чисел
//  начиная с 2, количество элементов в коллекции n
    public static Collection<Integer> fillEven(int n){
        Collection<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < n+1; i++)
            list1.add(i+i); //  i+i - четное число
        return list1;
    }
    //  создать коллекцию и заполнить последовательностью нечетных убывающих чисел,
//  минимальное число в коллекции 1, количество элементов в коллекции n
    public static Collection<Integer> fillOdd(int n){
//        Collection<Integer> list0 = new LinkedList<>();   //  недостаточно методов
        LinkedList<Integer> list1 = new LinkedList<>();
        int j = 0;
        for (int i = 1; ; i+=2) {
            list1.add(0, i);    //  добавление в начало для убывающего списка
            j++;
            if (j == n )
                break;
        }
        return list1;   //  возвращаем список LinkedList как потомка Collection
    }
    //  создать коллекцию и заполнить ее тройками чисел. Каждая тройка создается по алгоритму:
//  первое число тройки - индекс числа в коллекции, второе - индекс в квадрате,
//  третье - индекс в кубе, количество элементов в коллекции n*3
    public static Collection<Integer> fill3(int n){
        Collection<Integer> list0 = new ArrayList<>();
        for (int i = 0; i < n * 3; i+=3) {
            list0.add(i);
            list0.add(i * i);
            list0.add(i * i * i);
        }
        return list0;
    }
    public static void main(String[] args) {
//        System.out.println(fillEven(10));
//        System.out.println(fillOdd(11));
        System.out.println(fill3(3));
    }
}