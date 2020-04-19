package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
//    2.1 Реализовать функцию
//    которая возвращает значение бита с порядковым номером bitNumber от параметра value.
//    При этом следует помнить, что нумерация начинается с нуля и нулевой бит является младшим.

    public static int checkBit(byte value, int bitNumber){
        return value >>> bitNumber & 1;
    }

//    public static void main(String[] args) {
//        System.out.println(checkBit((byte) 0b0011_0000, 4));
//        System.out.println(checkBit((byte) 0b1111_0111, 3));
//    }
}
