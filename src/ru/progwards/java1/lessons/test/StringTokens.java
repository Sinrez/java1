package ru.progwards.java1.lessons.test;

import java.util.StringTokenizer;

public class StringTokens {
    public static void main(String[] args) {
        String txt =
                "StringTokenizer - этот класс, " +
                        "нам строку разобьёт на раз.";
        StringTokenizer tokenizer = new StringTokenizer(txt, " .,");
        while (tokenizer.hasMoreTokens())
            System.out.print(tokenizer.nextToken());
    }
}