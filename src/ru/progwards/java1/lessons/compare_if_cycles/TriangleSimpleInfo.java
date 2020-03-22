package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c){
        // должна наибольшую длину сторон
        if (a == 0 || b == 0 || c == 0) {
            return 0;
        }
        else if ((a >= b && a >= c)){
            return a;
        }
        else if ((b >= a && b >= c)){
            return b;
        }
         else return c;
        }

    public static int minSide(int a, int b, int c){
        //ернуть должна наименьшую длину стороны.
        if (a == 0 || b == 0 || c == 0) {
            return 0;
        }
        else if ((a <= b && a <= c)){
            return a;
        }
        else if ((b <= a && b <= c)){
            return b;
        }
        else return c;
    }


    public static boolean isEquilateralTriangle(int a, int b, int c){
        //вернуть должна true, если треугольник равносторонний и false в противном случае.
        if (a == 0 || b == 0 || c == 0) {
            return false;
        }
        else if (a == b && b ==c && a == c ){
            return true;
        }
        else return false;
    }

//    public static void main(String[] args) {
//     //check
//        System.out.println(maxSide(2,5,1));
//        System.out.println(minSide(3,1,5));
//        System.out.println(isEquilateralTriangle(4,4,4));
//        System.out.println(isEquilateralTriangle(4,5,4));
//
//        }
}
