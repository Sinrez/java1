package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    //для двоичного числа 0100101 функция должна вернуть 3.

    public static int sumBits(byte value) {
        // исправлен код для случая 0b00000001
        byte r = 0;
        if (value < 0) {
            r++;
            value &= 0b0111_1111;
        }
        while (value != 0) {
            r += value & 0b1;
            value >>= 1;
        }
        return r;
    }

    public static void main(String[] args) {
        SumBits sumBits = new SumBits();
        System.out.println(sumBits.sumBits((byte)0b00000001));

    }
}
