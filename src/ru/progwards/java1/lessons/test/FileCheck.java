package ru.progwards.java1.lessons.test;


import java.io.FileWriter;
import java.io.IOException;


//Напишите метод с сигнатурой public String test(String filename), который проверяет
//        filename и если он равен null выбрасывает IOException со строкой "File not found",
//        в противном случает возвращает строку "File processing"

public class FileCheck {
    public String test(String filename) {
        if(filename == null) {
            try {
                throw new IOException(
                        );
            } catch (IOException e) {
                //System.out.print(e);
                return e +" "+ "File not found";
            }
        } else {
          return "File processing";
        }
    }




    public static void main(String[] args) {
        FileCheck fileCheck = new FileCheck();
        System.out.println(fileCheck.test(null));
    }
}