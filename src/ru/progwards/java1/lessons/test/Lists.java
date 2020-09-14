package ru.progwards.java1.lessons.test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Lists {

/*
Напишите метод с сигнатурой public List<Integer> listAction(List<Integer> list), который выполняет следующие действия:
удаляет минимальный элемент коллекции
по индексу 0 добавляет число равное количеству элементов
по индексу 2 добавляет максимальный элемент из list
возвращает list как результат метода
*/


    public static List<Integer> listAction1(List<Integer> list) {
        if (list == null) return null;
        if (list.size() == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.addAll(list);
        int minIdx = 0, minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE, lastIdx = result.size() - 1;
        for (int i = lastIdx; i >= 0; i--) {
            int v = result.get(i);
            if (v > maxVal) maxVal = v;
            if (v < minVal) {
                minVal = v;
                minIdx = i;
            }
        }
        result.remove(minIdx);
        result.add(0, lastIdx);
        result.add(2, maxVal);
        return result;
    }

    public static List<Integer> listAction(List<Integer> list) {
        if (list == null) return null;
        if (list.size() == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.addAll(list);
        result.remove(Collections.min(result));
        result.add(0, result.size());
        result.add(2, Collections.max(result));
        return result;
    }

    /*
    Напишите метод, с сигнатурой public List<Integer> filter(List<Integer> list) который работает по следующему алгоритму
    суммирует значения всех элементов списка
    удаляет из списка элементы, значение которых меньше суммы, деленной на 100 (целочисленное деление)
    возвращает результирующий список
    */
    public static List<Integer> filter(List<Integer> list) {
        int sum = 0;
        for (int e : list) sum += e;
        List<Integer> result;
        if (list instanceof ArrayList) result = new ArrayList<>();
        else if (list instanceof LinkedList) result = new LinkedList<>();
        else if (list instanceof Vector) result = new Vector<>();
        else if (list instanceof Stack) result = new Stack<>();
        else if (list instanceof List) result = new ArrayList<>();
        else throw new RuntimeException("Unknown 'list' type!");
        int drop = sum / 100;
        for (Integer e : list) if (e < drop) result.add(e);
        return result;
    }

/*
Напишите метод с сигнатурой public void iterator3(ListIterator<Integer> iterator)
который заменяет значение каждого элемента, которое кратно 3 на значение его индекса.
*/

    public static void iterator3(ListIterator<Integer> iterator) {
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (n % 3 == 0) {
                iterator.set(iterator.nextIndex() - 1);
            }
        }
    }

    public static void main(String[] args) {
        /*List<Integer> list = Arrays.asList(new Integer[]{4, 5, 0, 3, 1, 2});
        System.out.println(list);
        System.out.println(listAction(list));
        System.out.println(listAction1(list));*/

        /*List<Integer> list = new ArrayList<>();
        for(Integer e:new Integer[]{40, 300, 0, 4, 3, 1, 2}) list.add(e);
        System.out.println(filter(list));*/

        List<Integer> list = new LinkedList<>();
        for (Integer e : new Integer[]{40, 300, 0, 4, 3, 1, 2}) list.add(e);
        System.out.println(list);
        iterator3(list.listIterator());
        System.out.println(list);
    }


}