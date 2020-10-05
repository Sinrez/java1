package ru.progwards.java1.lessons.test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayL {
    public static ArrayList<String> programmingLanguages = new ArrayList<>(Arrays.asList("C", "C++", "Python", "JavaScript", "Ruby", "Java", "Pascal"));

    public static void main(String[] args) {
        //напишите тут ваш код
        //"C", "C++", "Python", "JavaScript", "Ruby", "Java", "Pascal"));
        for (int i = 0; i < programmingLanguages.size(); i++) {
            if (!programmingLanguages.get(i).equals("Java")) {
                programmingLanguages.remove(i);
                i--;
            }

        }
        for (int j = 0; j < programmingLanguages.size(); j++) {
            System.out.println(programmingLanguages.get(j));
        }
    }
}