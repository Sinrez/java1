package ru.progwards.java1.lessons.basics;

public class Astronomy {

    public static Double sphereSquare(Double r) {
        final Double pi;
        pi = 3.14;
        //вычисляет площадь поверхности сферы радиуса R по формуле S = 4πR^2
        double s = 4 * pi * Math.pow(r, 2);
        return s;
    }

    public static Double earthSquare() {
        //которая вычисляет площадь поверхности Земли, считая радиус равным 6 371.2 км и используют функцию sphereSquare
        final double r = 6371.2;
        Double aDouble = sphereSquare(r);
        return aDouble;
    }

    public static Double mercurySquare() {
        //которая вычисляет площадь поверхности Меркурия, считая радиус равным 2 439,7 км
        // и используют функцию sphereSquare
        final double r = 2439.7;
         Double aDouble = sphereSquare(r);
        return aDouble;
    }

    public static Double jupiterSquare() {
        //которая вычисляет площадь поверхности Юпитера, считая радиус равным 71 492 км  и используют функцию sphereSquare
        final double r = 71492;
         Double aDouble = sphereSquare(r);
        return aDouble;
    }

    public static Double earthVsMercury() {
        //которая вычисляет отношение площади поверхности Земли к площади поверхности Меркурия используя готовые функции площадей планет
        return earthSquare() / mercurySquare();
    }

        public static Double earthVsJupiter (){
        //которая вычисляет отношение площади поверхности Земли к площади поверхности Юпитера используя готовые функции площадей планет
        return earthSquare() / mercurySquare();

    }

//    public static void main(String[] args) {
//        System.out.println(earthSquare());
//        System.out.println(mercurySquare());
//        System.out.println(jupiterSquare());
//        System.out.println(earthVsMercury());
//        System.out.println(earthVsJupiter ());
//
//    }
}