package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c){
        // должна наибольшую длину стороны
        int max = a;
        if (b > max && b > c){
            return b;
        }
        else if (c > max && c > b){
            return c;
        }
        else return max;
    }

    public static int minSide(int a, int b, int c){
        //ернуть должна наименьшую длину стороны.
        int min = a;
        if (b < min && b < c){
            return b;
        }
        else if (c < min && c < b){
            return c;
        }
        else return min;
    }


    public static boolean isEquilateralTriangle(int a, int b, int c){
        //вернуть должна true, если треугольник равносторонний и false в противном случае.
        if (a == b && b ==c ){
            return true;
        }
        else return false;
    }

//    public static void main(String[] args) {
    // check
//        System.out.println(maxSide(2,5,1));
//        System.out.println(minSide(3,1,5));
//        System.out.println(isEquilateralTriangle(4,4,4));
//        System.out.println(isEquilateralTriangle(4,5,4));
//
//        }
}
