package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    byte number;


    ByteInteger(byte number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Byte.toString(number);
    }

    @Override
    public int absValue() {
        return this.number;
    }
}