package ru.progwards.java1.lessons.test;

public class Sol1 {
    //public class Solution {
        public static void main(String[] args) {
            String string = "Чтобы стать программистом, нужно писать код, а чтобы писать код, нужно учиться, а чтобы учиться, нужно желание.";
            String word = "код";
            int indexFromFirstWord = getIndexFromFirstWord(string, word);
            int indexFromLastWord = getIndexFromLastWord(string, word);
            System.out.println("Индекс первого символа первого слова \"" + word + "\" равен - " + indexFromFirstWord);
            System.out.println("Индекс первого символа последнего слова \"" + word + "\" равен - " + indexFromLastWord);
        }

        public static int getIndexFromFirstWord(String string, String word) {
            //напишите тут ваш код
            char c = word.charAt(0);
            int index1 = string.indexOf(c);
            return index1;
        }

        public static int getIndexFromLastWord(String string, String word) {
            char z = word.charAt(0);
            int index2 = string.lastIndexOf(word);
            //int l = string.length();
          int index3 = string.lastIndexOf(z, index2);
            return index3;
        }
        //return 0;}
    }

