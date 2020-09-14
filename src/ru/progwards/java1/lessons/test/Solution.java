package ru.progwards.java1.lessons.test;



/*
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        //напишите тут ваш код
        String bin = "";
        if (decimalNumber <= 0){
            return null;
        } else if (decimalNumber > 0){
            while (decimalNumber >= 1){
                bin = decimalNumber % 2 + bin;
                decimalNumber = decimalNumber / 2;
            }
        } return bin;

    }

    public static int toDecimal(String binaryNumber) {
        //напишите тут ваш код
        int dec = 0;
        if (binaryNumber.equals(" ") || binaryNumber.equals(null)){
            return 0;
        } else {
            char[] array = binaryNumber.toCharArray();
             dec = array.length-1;
            for(int i = 0; i < array.length; i++){
                dec = (int)(dec + Character.getNumericValue(array[i]) * Math.pow(2, dec));
                dec--;
            }

        }return dec;

    }
}
