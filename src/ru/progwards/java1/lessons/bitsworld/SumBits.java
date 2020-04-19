package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    //для двоичного числа 0100101 функция должна вернуть 3.

    public static int sumBits(byte value){
        {
            int count = 0;

            while (value != 0)
            {
                count += (value >>= 1) & 0b1;
            }
            return count;
        }
    }
//    public static void main(String[] args) {
//        SumBits sumBits = new SumBits();
//        System.out.println(sumBits.sumBits((byte)0b0010_0110));
//
//    }
}
