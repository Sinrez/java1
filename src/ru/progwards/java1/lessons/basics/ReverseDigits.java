package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static int reverseDigits(int number){
        String a = Integer.toString(number / 100);
        String b = Integer.toString(number % 100 / 10);
        String c = Integer.toString(number % 100 % 10);
        String s = (c + b + a);
        int z = Integer.parseInt(s);
        return z;
    }

    public static void main(String[] args) {
        System.out.println(reverseDigits(123));

    }
}
