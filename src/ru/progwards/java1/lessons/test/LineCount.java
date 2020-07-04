package ru.progwards.java1.lessons.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {
    //    Реализовать метод с сигнатурой private int lineCount(String filename)
//    который возвращает количество строк в файле filename.
//    В случае ошибки пробросить исключение IOException со строкой сообщения "файл не найден"
    private int lineCount(String filename) {
        int count = 0;
        try {
            try (FileReader reader = new FileReader(filename)) {
                try {
                    Scanner scanner = new Scanner(reader);
                    while (scanner.hasNextLine()) {
                        String strFromFile = scanner.nextLine();
                        if (strFromFile.length() == 0)
                            count++;
                    }
                } finally {
                    reader.close();
                }
            }
        } catch (IOException e) {
//            throw new IOException("файл не найден");
            return -1;
        }
        return count;
    }

    public static void main(String[] args){
        LineCount lineCount = new LineCount();

        System.out.println(lineCount.lineCount("/Users/sintez/Desktop/id компа дом.rtf"));
    }
}


