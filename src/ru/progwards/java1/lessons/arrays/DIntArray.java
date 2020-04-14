package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
//    Реализовать динамический, саморастущий массив целых чисел, по следующей спецификации:
    private int [] mass = new int[]{};

    public DIntArray(){
    }
    //        public void add(int num) - добавляет элемент num в конец массива,
//        при этом размер массива должен увеличиться на 1.
//        Для этого нужно будет разместить новый массив нужного размера,
//        скопировать в него старый, и добавить в хвост элемент num.
    public void add(int num){

        if (num > mass.length) {
            return;
        }

        int[] massCopy = Arrays.copyOf(mass, mass.length + 1);
        massCopy[massCopy.length - 1] = num;

        //check
//        System.out.println("Исходный");
//        System.out.println(Arrays.toString(mass));
//        System.out.println("с добавлением");
//        System.out.println(Arrays.toString(massCopy));
    }

    public void atInsert(int pos, int num){
        //    - добавляет элемент num в позицию pos массива,
//    при этом размер массива должен увеличиться на 1. Для этого нужно будет разместить
//    новый массив нужного размера, скопировать в него старый,
//    c учетом того, что новый элемент окажется где-то в середине, и потом положить в нужный индекс элемент num.
        int i;
        int newarr[] = new int[mass.length + 1];
        for (i = 0; i < mass.length + 1; i++) {
            if (i < pos - 1)
                newarr[i] = mass[i];
            else if (i == pos - 1)
                newarr[i] = num;
            else
                newarr[i] = mass[i - 1];
        }
//        System.out.println(Arrays.toString(newarr));
    }

    public void atDelete(int pos){
        //удаляет элемент в позиции pos массива,
//    при этом размер массива должен уменьшиться на 1.
//    Для этого нужно будет разместить новый массив нужного размера, скопировать в него старый, уже без элемента, который был в позиции pos
        int[] massDel = new int[mass.length-1];
        if (mass == null || pos < 0 || pos >= mass.length) {
            System.out.println("Ошибка формата массива");
        } else {
            for (int i = 0, k = 0; i < mass.length; i++) {
                // если индекс  элемента удаления
                if (i == pos) {
                    continue;
                }
                // если индекс не индекс элемента удаления
                massDel[k++] = mass[i];
            }
        }
//        System.out.println(Arrays.toString(massDel));
    }

    public int at(int pos){
        //            3.5 метод
//    - возвращает элемент по индексу pos.
        return mass[pos];
    }

//    public static void main(String[] args) {
//        DIntArray dIntArray = new DIntArray();
//        dIntArray.mass = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(dIntArray.at(5));
//        dIntArray.add(7);
//        dIntArray.atDelete(1);
//        dIntArray.atInsert(1, 99999);
//    }
}
