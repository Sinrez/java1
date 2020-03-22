package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {

    public static boolean isTriangle(int a, int b, int c){
//        которая возвращает true, если по данным трём сторонам (a, b, c)
//        можно построить треугольник. Из геометрии известно,
//                что в треугольнике длина каждой из сторон меньше суммы длин двух других сторон.
        if (c < (a + b) && b < (a + c) && a < (b + c)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isRightTriangle(int a, int b, int c){
         if (a > 0 && b > 0 && c > 0 && (c * c == a * a + b * b || b * b == a * a + c * c || a * a == b * b + c * c)){
            return true;
        } else {
            return false;
        }
//    которая возвращает true, если треугольник со сторонами
//        a, b, c является прямоугольным. Из геометрии известно,
//    что для прямоугольного треугольника выполняется теорема Пифагора (сумма квадратов катетов равна квадрату гипотенузы).


    }

    public static boolean isIsoscelesTriangle(int a, int b, int c){
        //    которая возвращает true, если треугольник со сторонами a, b, c является равнобедренным.
//    Из геометрии известно, что в равнобедренном треугольнике есть две равные стороны.
        if (( a > 0 && b > 0 && c > 0) && (a == b || a == c || b == c)){
            return true;
        } else {
            return false;
        }

    }

//    public static void main(String[] args) {
//        System.out.println(isTriangle(3,4,5));
//        System.out.println(isTriangle(9,9,9));
//        System.out.println(isTriangle(0,0,0));
//        System.out.println(isRightTriangle(5, 12 , 13));
//        // числа для проверки https://scientificmagazine.ru/images/PDF/2016/12/tablitsa-pifagorovykh-troek-chisel.pdf
//        System.out.println(isIsoscelesTriangle(5,2,5));
//    }

}
