package ru.progwards.java1.lessons.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilesSelect {
    // поиск ключевиков во всех файлах каталога, копирование в папки с названиями ключевиков
    public static void selectFiles(String inFolder, String outFolder, List<String> keys) {
        List<Path> paths = null;
        try {
            paths = Files.walk(Paths.get(inFolder))
                    .filter(s -> s.toString().endsWith(".txt"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(paths);
        if (paths != null)
            for (Path path : paths) {
                String key = findKey(path, keys);
                if (key != null) copyFile(path, outFolder, key);
            }
    }

    // найти ключевую последовательность символов в файле
    private static String findKey(Path path, List<String> keys) {
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String key : keys) {
                    if (line.indexOf(key) >= 0) return key;
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }

    // скопировать файл в подкаталог
    private static void copyFile(Path path, String outFolder, String subFolder) {
        Path destPath = Paths.get(outFolder + "/" + subFolder);
        Path dest = Paths.get(outFolder + "/" + subFolder + "/" + path.getFileName());
        //System.out.println("copy "+path+" -> "+dest);
        try {
            if (Files.notExists(destPath)) Files.createDirectories(destPath);
            Files.copy(path, dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        selectFiles(".", "out", Arrays.asList("ttt1", "File5", "One"));
    }

}