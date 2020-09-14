package ru.progwards.java1.lessons.test;

public class TestSrt {
    public static String swapWords(String sentance) {
        String str = sentance.replaceAll("[!,.-]", "");
        String[] strings = str.split("\\s+");
        for (int i = 1; i < strings.length; i = i + 2) {
            String tmp = strings[i - 1];
            strings[i - 1] = strings[i];
            strings[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i] + " ");
        }
        return sb.toString().trim();
    }
}