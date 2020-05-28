package ru.progwards.java1.lessons.bigints;


import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
    byte[] digits;

    ArrayInteger(int n) {
        digits = new byte[n];
    }

    void fromInt(BigInteger value) {
        BigInteger tmp = value;
        int size = value.toString().length();
        for (int i = 0; i < size; i++) {
            this.digits[i] = (value.mod(BigInteger.valueOf(10))).byteValue();
            value = value.divide(BigInteger.valueOf(10));
        }
    }

    BigInteger toInt() {
        String s = "";
        for (int i = this.digits.length - 1; i >= 0; i--) {
            s += digits[i] + "";
        }

        BigInteger result = new BigInteger(s);
        return result;
    }

    boolean add(ArrayInteger num) {

        if (num.digits.length > this.digits.length) {
            Arrays.fill(this.digits, (byte) 0);
            return false;
        }

        byte result;
        byte result_2 = 0;
//        BigInteger result = BigInteger.valueOf(0);

        for (int i = 0; i < this.digits.length; i++) {
            if (i < num.digits.length) {
                result = (byte) (((this.digits[i] + num.digits[i])) % 10 + result_2);
                result_2 = 0;
                result_2 = (byte)(((this.digits[i] + num.digits[i]))/10);
            }
            else {
                result = (byte) (((this.digits[i] + result_2)) % 10);
                System.out.print(i + " result = " + result);
//                result_2 = 0;
                result_2 = (byte) (((this.digits[i] + result_2)) / 10);
                if (result_2 > 0){
                    this.digits[i] = result;
                    continue;
                }

                System.out.println("; result2 = " + result_2);
            }
            this.digits[i] = result;
        }
        if (result_2 > 0){
            Arrays.fill(this.digits, (byte) 0);
            return false;
        }
//            if (i < num.digits.length) {
//                result_1 = BigInteger.valueOf(this.digits[i]).add(BigInteger.valueOf(num.digits[i]));
//            } else {
//                result_1 = BigInteger.valueOf(this.digits[i]);
//            }
//            result_2 = result_1.multiply(BigInteger.valueOf(10).pow(i));
//            result = result.add(result_2);
//        }
//        if (result.toString().length() > this.digits.length){
//            Arrays.fill(this.digits, (byte) 0);
//            return false;
//        }
//            this.fromInt(result);
        return true;
    }

    public static void main (String[]args){
        ArrayInteger num = new ArrayInteger(4);
        num.fromInt(BigInteger.valueOf(3333));
        ArrayInteger a = new ArrayInteger(5);
        a.fromInt(BigInteger.valueOf(97222));
        a.add(num);
        System.out.println(a.toInt());
    }
}
