package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.util.*;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            FileReader reader = new FileReader(inFileName);
            StringBuffer D = new StringBuffer("");
            for (int c; (c = reader.read()) != -1; ) {
                D.append(code[(int) c]);
            }
            FileWriter writer = new FileWriter(outFileName);
            try {
                writer.write(D.toString());
            } finally {
                try {
                    writer.close();
                } catch (Throwable t) {
                    throw t;
                } finally {
                    try {
                        reader.close();
                    } catch (Throwable t) {
                        throw t;
                    }
                }
            }
        } catch (Throwable t) {
            try {
                FileWriter writer = new FileWriter(logName, true);
                writer.write(t.getMessage()+ "\n");
                try {
                    writer.close();
                } catch (Throwable e) {
//                    t.printStackTrace();
                    throw e;
                }
            } catch (Throwable w) {
                System.out.println(w.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        String a = "abcdefghhjk";
        for (int i = 1; i <= 2; i++) {
            a += a;
        }
        char b[] = a.toCharArray();
        try {
            codeFile("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\fileName.txt",
                    "C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\file out", b,
                    "C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\logName");
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
    }
}