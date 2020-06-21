package ru.progwards.java1.lessons.io2;

import java.io.IOException;
import java.util.Scanner;

public class Translator {
    private String[] inLang;
    private String[] outLang;
    Translator(String[] inLang, String[] outLang){
        this.inLang = inLang;
        this.outLang = outLang;
    }
    public String translate(String sentence){
        try {
            for (int i=0; i<inLang.length; i++){
                boolean toUp = false;
                int pos = sentence.toLowerCase().indexOf(inLang[i]);
//            System.out.println("i = " + i + " -> " + inLang[i] + " -> " + ", pos = " +pos);
                if (pos >= 0) {
                    sentence = sentence.replace(firstUp(inLang[i]), firstUp(outLang[i]));
                    sentence = sentence.replace(inLang[i], outLang[i]);
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return sentence;
    }
    public String firstUp(String original){
        //  перевести первую букву в заглавную
        int len = original.length();
        switch (len){
            case 0:     return "";
            case 1:     return original.substring(0,1).toUpperCase();
            default:    return original.substring(0,1).toUpperCase() + original.substring(1);
        }
    }

    public static void main(String[] args){
        String[] eng = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "i"};
        String[] rus = {"раз", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "я"};  //, "я"
        Translator engRus = new Translator(eng, rus);
        String text = "One, two, three, four, five,\n" +
                "Once I caught a fish alive,\n" +
                "Six, seven, eight, nine, ten,\n" +
                "Then I let it go again.\n";
        System.out.println(engRus.translate(text));
    }
}
