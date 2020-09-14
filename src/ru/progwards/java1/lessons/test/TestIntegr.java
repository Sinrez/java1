package ru.progwards.java1.lessons.test;


import java.util.Arrays;

public class TestIntegr {

//    Реализуйте функцию, возвращающую
//    максимальный по значению элемент массива.
//    Если в массиве 0 элементов, вернуть 0. Сигнатура функции
//    Подсказка - для быстрой реализации удобно использовать функцию Arrays.sort()
//    public int arrayMax(int[] a){
//        int max = 0;
//        if(a.length == 0){
//            max = 0;
//        } else {
//           for (int i = 0; i < a.length; i++){
//               if(a[i] > max){
//                   max = a[i];
//               }
//           }
//        }
//        return max;
//    }

//    public int arrayMax(int[] a) {
//        int max = 0;
//        if (a.length == 0) {
//            max = 0;
//        } else {
//            Arrays.sort(a);
//            max = a[a.length -1];
//        }
//        return max;
//    }


    public static void main(String[] args) {
        TestIntegr testIntegr = new TestIntegr();
        int[] TestArr = {23, 44, 99, 100, 2, 43};
       // System.out.println(testIntegr.arrayMax(TestArr));
        int[] a1 = {12, 5, 0, 58, 36};
        int[] a2 = Arrays.copyOf(a1, a1.length);
        Arrays.sort(a2);
        System.out.println(Arrays.equals(a1, a2));

//        int[] a1 = {1, 1, 1, 1, 3};
//        int[] a2 = new int[5];
//        Arrays.fill(a2, 1);
//        a2[4] = 3;
//        System.out.println(Arrays.equals(a1, a2));
//
//        int[] a1 = {12, 5, 0, 58, 36};
//        int[] a2 = Arrays.copyOf(a1, a1.length);
//        a2[2] = 0;
//        System.out.println(Arrays.equals(a1, a2));


    }


//
//
//    public int sumArrayItems(int[] a) {
//        int sum = 0;
//        for (int i = 0; i < a.length; i++) {
//            sum += a[i];
//        }
//        return sum;
//
//    }
//
//    public static void main(String[] args) {
//        TestIntegr testIntegr = new TestIntegr();
//        int [] testArr = {10, 20, 30, 40};
//        System.out.println(testIntegr.sumArrayItems(testArr));
//    }

//    class Rectangle {
//        private double a;
//        private double b;
//
//        public Rectangle(double a, double b) {
//            this.a = a;
//            this.b = b;
//        }
//
//        public double area() {
//
//            return a*b;
//        }
//
//        //Rectangle(2,2).compareTo(new Rectangle(3, 3))
//
//        public int compareTo(Rectangle anRectangle){
//            //который должен сравнивать прямоугольники по величине их площади.
////        При сравнении a.compareTo(b) метод должен возвращать
////        a   > b : 1
////        a == b : 0
////        a   < b : -1
//            if (this.a * this.b > anRectangle.a * anRectangle.b){
//                return 1;
//            } else if (this.a * this.b == anRectangle.a * anRectangle.b){
//                return 0;
//            }else {
//                return -1;
//            }
//
//        }
//    }



}









