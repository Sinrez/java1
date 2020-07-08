package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class UsageFrequency {

    static Map<Character, Integer> letters;
    static Map<String, Integer> words;

    // загрузить содержимое файла
    public static void processFile(String fileName) {
        letters = new HashMap<Character, Integer>(500);
        words = new HashMap<String, Integer>(5000);
        try (FileReader r = new FileReader(fileName); Scanner s = new Scanner(r)) {
            while (s.hasNext()) {
                processLine(s.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(fileName + ":\n" + e.getMessage());
        }
    }

    // загрузить содержимое строки
    private static void processLine(String str) {
        //System.out.println(str);
        int wordBeginIdx = -1;
        Character keyChar;
        String keyWord;
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            keyChar = str.charAt(i);
            //if (Character.isLetter(keyChar)) { // странно, почему в тесте цифры идут за символы. Используем isLetterOrDigit
            if (Character.isLetterOrDigit(keyChar)) {
                letters.put(keyChar, letters.containsKey(keyChar) ? 1 + letters.get(keyChar) : 1);
                if (wordBeginIdx < 0) wordBeginIdx = i;
            } else {
                if (wordBeginIdx >= 0) {
                    keyWord = str.substring(wordBeginIdx, i);
                    words.put(keyWord, words.containsKey(keyWord) ? 1 + words.get(keyWord) : 1);
                    wordBeginIdx = -1;
                }
            }
        }
        if (wordBeginIdx >= 0) {
            keyWord = str.substring(wordBeginIdx, strLen);
            words.put(keyWord, words.containsKey(keyWord) ? 1 + words.get(keyWord) : 1);
        }
    }

    // вернуть Map, который содержит все найденные буквы и цифры
    public static Map<Character, Integer> getLetters() {
        return letters;
    }

    // вернуть Map, который содержит все найденные слова
    public static Map<String, Integer> getWords() {
        return words;
    }

    public static void main(String[] args) {
        processFile("..\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\UsageFrequency.java");
        System.out.println(getLetters());
        System.out.println(getWords());
    }
}
