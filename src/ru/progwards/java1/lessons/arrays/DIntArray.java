package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
//    Реализовать динамический, саморастущий массив целых чисел, по следующей спецификации:
    private int [] mass;

    public DIntArray(){
        mass = new int[]{};
    }
    //        public void add(int num) - добавляет элемент num в конец массива,
//        при этом размер массива должен увеличиться на 1.
//        Для этого нужно будет разместить новый массив нужного размера,
//        скопировать в него старый, и добавить в хвост элемент num.
    public void add(int num){

//        if (mass.length + 1 < 0) {
//            return;
//        }

        int[] massCopy = Arrays.copyOf(mass, mass.length + 1);
        massCopy[massCopy.length - 1] = num;
        int[] mass = Arrays. copyOf(massCopy, massCopy.length);

        //check
        System.out.println("Исходный");
        System.out.println(Arrays.toString(mass));
        System.out.println("с добавлением");
        System.out.println(Arrays.toString(massCopy));
    }

    public void atInsert(int pos, int num){
        //    - добавляет элемент num в позицию pos массива,
//    при этом размер массива должен увеличиться на 1. Для этого нужно будет разместить
//    новый массив нужного размера, скопировать в него старый,
//    c учетом того, что новый элемент окажется где-то в середине, и потом положить в нужный индекс элемент num.
        int i = 0;

        int newarr[] = new int[mass.length + 1];
        for (i = 0; i < mass.length + 1; i++) {
            if (i < pos - 1)
                newarr[i] = mass[i];
            else if (i == pos - 1)
                newarr[i] = num;
            else
                newarr[i] = mass[i - 1];
        }
        int[] mass = Arrays. copyOf(newarr, newarr.length);
//        System.out.println(Arrays.toString(newarr));
//        System.out.println("тестируем старый после добавления");
//        System.out.println(Arrays.toString(mass));
    }

    public void atDelete(int pos){
        //удаляет элемент в позиции pos массива,
//    при этом размер массива должен уменьшиться на 1.
//    Для этого нужно будет разместить новый массив нужного размера, скопировать в него старый, уже без элемента, который был в позиции pos

        int[] massDel = new int[mass.length-1];
//        if (mass == null || pos < 0 || pos >= mass.length || mass.length-1 < 0) {
//            System.out.println("Ошибка формата массива");
//        } else {
            for (int i = 0, k = 0; i < mass.length; i++) {
                // если индекс  элемента удаления
                if (i == pos) {
                    continue;
                }
                // если индекс не индекс элемента удаления
                massDel[k++] = mass[i];
            }
        int[] mass = Arrays. copyOf(massDel, massDel.length);
        //}
        System.out.println(Arrays.toString(massDel));
    }

    public int at(int pos) {
       return mass[pos];
        }


    public static void main(String[] args) {
        DIntArray dIntArray = new DIntArray();
        dIntArray.mass = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(dIntArray.at(5));
        dIntArray.add(6);
        dIntArray.atDelete(0);
        dIntArray.atInsert(1, 99999);
    }
}
