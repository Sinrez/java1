package ru.progwards.java1.lessons.sets;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LettersInFile {

    public static String process1(String fileName) throws IOException {
        Set<Character> set = new HashSet<Character>();
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            str.toCharArray();
            char[] charArray = str.toCharArray();
            for (char aChar : charArray) {
                if (Character.isLetter(aChar)) set.add(aChar);
            }
        }
        scanner.close();
        fileReader.close();

        List<Character> list = new ArrayList<>(set);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder(100);
        for (Character aChar : list) {
            sb.append(aChar);
        }
        return sb.toString();
    }

    public static String process2(String fileName) throws IOException {
        String set = "";
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            str.toCharArray();
            char[] charArray = str.toCharArray();
            for (char aChar : charArray) {
                if (Character.isLetter(aChar)) {
                    if (set.indexOf(aChar) == -1) set += aChar;
                }
            }
        }
        scanner.close();
        fileReader.close();

        char[] charArray = set.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char aChar : charArray) {
            list.add(aChar);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder(100);
        for (Character aChar : list) {
            sb.append(aChar);
        }
        return sb.toString();
    }

    public static String process(String fileName) throws IOException {
        return process1(fileName); //122-124
        //return process2(fileName); //123-125
    }

    public static void processFilesFromFolder(File folder) throws IOException {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                processFilesFromFolder(entry);
                continue;
            } else {
                if (entry.getName().indexOf(".java") > 0) {
                    //System.out.println(entry.getPath());
                    //System.out.println(process(entry.getPath()));
                    process(entry.getPath());
                }
            }
        }
    }

    public static long iteration() throws IOException {
        long startTime = System.currentTimeMillis();
        File folder = new File(".");
        processFilesFromFolder(folder);
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        try {
            long allTime = 0;
            int tryCount = 100;
            for (int i = 0; i < tryCount; i++) {
                allTime += iteration();
            }
            System.out.println(allTime / tryCount);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
