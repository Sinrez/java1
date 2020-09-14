package ru.progwards.java1.lessons.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class RectangleBigInt {
////    BigDecimal bigDec1 = BigDecimal.valueOf(10);
////    BigDecimal bigDec2 = BigDecimal.valueOf(3);
////    BigDecimal result = bigDec1.divide(bigDec2, 5, RoundingMode.HALF_UP);

//BigDecimal bigDec1 = BigDecimal.valueOf(10);
//        BigDecimal bigDec2 = BigDecimal.valueOf(3);
//        BigDecimal result = bigDec1.divide(bigDec2);


//MathContext mathContext = new MathContext(3);
//        BigDecimal result = new BigDecimal("3.3333", mathContext);

    static class Rectangle {

        Rectangle(BigDecimal a, BigDecimal b) {
            this.a = a;
            this.b = b;
        }
        public BigDecimal a;
        public BigDecimal b;

        @Override
        public String toString() {
            return "Rectangle{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    static boolean rectCompare(Rectangle r1, Rectangle r2) {
        BigDecimal s1 = r1.a.multiply(r1.b);
        BigDecimal s2 = r2.a.multiply(r2.b);
        return s1.compareTo(s2) == 0;
    }

//    public static void main(String[] args) {
//        RectangleBigInt rectangleBigInt = new RectangleBigInt();
//        System.out.println(rectangleBigInt.result);
//    }



}

