package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {
    int number;

    public IntInteger(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
    @Override
    public int absValue() {
        return this.number;
    }
}
