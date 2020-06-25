package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

/*
Сделать итератор MatrixIterator по двумерному массиву (матрице),
который разворачивает матрицу в линейную последовательность построчно:
a[0][0], a[0][1], ...a[0][N],a[1][0], a[1][1]...a[1][N]... a[M][N]
Шаблон для итератора взять от ArrayIterator
*/

public class MatrixIterator<T> implements Iterator<T> {

    private T[][] array;
    int len;
    int idx;
    int nextIdx;
    ArrayIterator<T> iterator;
    ArrayIterator<T> nextIterator;

    MatrixIterator(T[][] array) {
        this.array = array;
        len = array == null ? -1 : array.length;
        idx = -1;
        calcNextIterator();
        iterator = nextIterator;
        idx = nextIdx;
    }

    void calcNextIterator() {
        int i = idx + 1;
        while (i < len) {
            if (array[i] != null && array[i].length > 0) {
                nextIterator = new ArrayIterator<>(array[i]);
                nextIdx = i;
                return;
            }
            i++;
        }
        nextIterator = null;
    }

    @Override
    public boolean hasNext() {
        return nextIterator != null;
    }

    @Override
    public T next() {
        if (!iterator.hasNext()) {
            idx = nextIdx;
            iterator = nextIterator;
        }
        T result = iterator.next();
        if (!iterator.hasNext()) calcNextIterator();
        return result;
    }

    public static void main(String[] args) {
        //MatrixIterator<Integer> i = new MatrixIterator<>(new Integer[][]{new Integer[]{2, 2, 2}, new Integer[]{1, 2, 3}, null});
        MatrixIterator<Integer> i = new MatrixIterator<>(new Integer[][]{null, new Integer[]{}, null});
        while (i.hasNext()) System.out.println(i.next());
    }
}