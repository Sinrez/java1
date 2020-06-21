package ru.progwards.java1.lessons.io2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Censor {

    public static class CensorException extends RuntimeException{
        public String fileName = "";
        public CensorException(String fileName){
            super("Неправильное имя файла :");
            this.fileName = fileName;
        }
        @Override
        public String getMessage() {
            return super.getMessage() + (fileName == null ? "null" : "\"" + fileName + "\"");
        }
    }

    public static void censorFile(String inoutFileName, String[] obscene){
        final String ASTER = "*";
        try (RandomAccessFile raf = new RandomAccessFile(inoutFileName, "rw")) {
            String currentLine = raf.readLine();
            if (currentLine != null){
                currentLine = new String(currentLine.getBytes("ISO-8859-1"), "UTF-8");
                System.out.println(currentLine);
            }
            for (String word : obscene){
                int len = word.length();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    builder.append(ASTER);
                }
                String result = builder.toString();
                currentLine = currentLine.replace(word, result);
                System.out.println(word+"|"+result+"|"+currentLine);
            }
            raf.seek(0);
            byte[] to1 = currentLine.getBytes();
            raf.write(to1);
        } catch (Exception e) {
            throw new CensorException(inoutFileName);
        }
    }

    public static void main(String[] args) {
        String[] obscene = {"Java", "Oracle", "Sun", "Microsystems"};
//        censorFile("C:\\Users\\sidne\\IdeaProjects\\HelloWorld\\src\\ru\\progwards\\java1\\lessons\\io2\\file1.txt", obscene);
        censorFile(null, obscene);
    }
}