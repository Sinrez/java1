package ru.progwards.java1.lessons.test;

import java.util.Calendar;
import java.time.LocalDate;
import java.time.Instant;

/*
Текущий год
*/
public class Solution1 {

    private int currentYear;

    public void Solution() {
        this.currentYear =  Integer.parseInt(Instant.now().toString());
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.getCurrentYear());
    }
}