package ru.progwards.java1.lessons.files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

interface IGetPathValue<TypeResult, TypeParam> {
    TypeResult get(TypeParam p);
}

public class FindDuplicates {
// В заданном каталоге и его подкаталогах найти файлы, точно совпадающие по названию (и расширению),
// дате-времени последнего изменения, размеру и по содержимому. Сигнатура метода
// public List<List<String>> findDuplicates(String startPath)
// , результат - список, содержащий списки строк с именами и полными путями совпадающих файлов.

    // В заданном каталоге и его подкаталогах найти файлы, точно совпадающие
    public static List<List<String>> findDuplicates(String startPath) {
        System.out.println("Reading directory...");
        List<Path> path = readAllPathsNio(startPath);
        if (path == null) return null;
        List<List<Path>> paths = new ArrayList<List<Path>>();
        paths.add(path);
        System.out.println("found: " + countAll((Collection) paths) + "\n");

        // с одинаковыми именами
        System.out.println("Search equal names...");
        paths = getEquals(paths, p -> p.getFileName().toString());
        System.out.println("found: " + countAll((Collection) paths) + "\n");

        // с одинаковой датой-временем последнего изменения
        System.out.println("Search equal modify time...");
        paths = getEquals(paths, p -> {
            try {
                //return Files.getLastModifiedTime(p);
                return Files.getAttribute(p, "basic:lastModifiedTime");
            } catch (IOException e) {
                return null;
            }
        });
        System.out.println("found: " + countAll((Collection) paths) + "\n");

        // с одинаковым размером
        System.out.println("Search equal size...");
        paths = getEquals(paths, p -> {
            try {
                return Files.size(p);
            } catch (IOException e) {
                return null;
            }
        });
        System.out.println("found: " + countAll((Collection) paths) + "\n");

        // с одинаковым содержимым
        System.out.println("Search for the same content...");
        paths = getEquals(paths, (o1, o2) -> isEqualPaths(o1, o2) ? 0 : 1);
        System.out.println("found: " + countAll((Collection) paths) + "\n");

        // преобразуем к List<List<String>>
        List<List<String>> result = new ArrayList<List<String>>(paths.size());
        for (List<Path> pl : paths) {
            List<String> l = new ArrayList<String>(pl.size());
            for (Path p : pl) l.add(p.toString());
            result.add(l);
        }
        return result;
    }

    // посчитать общее количество элементов вместе со всеми подколлекциями
    public static int countAll(Collection<Object> inCollection) {
        int result = inCollection.size();
        if (result > 0) {
            Iterator i = inCollection.iterator();
            Object o = i.next();
            if (o instanceof Collection) {
                result += countAll((Collection) o);
                while (i.hasNext()) {
                    result += countAll((Collection) i.next());
                }
            }
        }
        return result;
    }

    // сравнить содержимое двух файлов
    public static boolean isEqualPaths(Path path1, Path path2) {
        try (
                InputStream f1 = Files.newInputStream(path1);
                InputStream f2 = Files.newInputStream(path2);
        ) {
            long fSize = Files.size(path1);
            int bufSize = (int) (fSize / 16);
            final int minBufSize = 128 * 1024;
            final int maxBufSize = 1 * 1024 * 1024;
            if (bufSize > maxBufSize || fSize > Integer.MAX_VALUE) bufSize = maxBufSize;
            else if (bufSize < minBufSize)
                if (fSize < minBufSize) bufSize = (int) fSize;
                else bufSize = (int) fSize / 4;
            try (
                    BufferedInputStream s1 = new BufferedInputStream(f1, bufSize);
                    BufferedInputStream s2 = new BufferedInputStream(f2, bufSize);
            ) {
                int b1 = 0;
                while ((b1 = s1.read()) != -1) {
                    if (b1 != s2.read()) return false;
                }
                //System.out.println(b1);
                return s2.read() == -1;
                //return false;
            }
        } catch (Throwable e) {
            return false;
        }
    }

    public static boolean isEqualPaths2(Path path1, Path path2) {
        try (
                InputStream f1 = Files.newInputStream(path1);
                InputStream f2 = Files.newInputStream(path2);
        ) {
            long fSize = Files.size(path1);
            int bufSize = (int) (fSize / 16);
            final int minBufSize = 128 * 1024;
            final int maxBufSize = 1 * 1024 * 1024;
            if (bufSize > maxBufSize || fSize > Integer.MAX_VALUE) bufSize = maxBufSize;
            else if (bufSize < minBufSize)
                if (fSize < minBufSize) bufSize = (int) fSize;
                else bufSize = (int) fSize / 4;
            try (
                    BufferedInputStream s1 = new BufferedInputStream(f1, bufSize);
                    BufferedInputStream s2 = new BufferedInputStream(f2, bufSize);
            ) {
                int b1;
                while ((b1 = s1.read()) != -1) {
                    if (b1 != s2.read()) return false;
                }
                return s2.read() == -1;
            }
        } catch (Throwable e) {
            return false;
        }
    }

    // в заданных списках оставит только с одинаковым результатом comparatorFunc
    public static <T> List<List<T>> getEquals(List<List<T>> paths, Comparator<T> comparatorFunc) {
        List<List<T>> result = new ArrayList<List<T>>();
        for (List<T> pList : paths) {
            int[] foundIdx = new int[pList.size()]; // массив найенных, храним индекс в массиве результатов
            boolean[] found = new boolean[pList.size()]; // массив найенных, храним индекс в массиве результатов
            int i1 = -1;
            for (T p1 : pList) {
                i1++;
                if (!found[i1]) {
                    found[i1] = true;
                    int i2 = -1;
                    for (T p2 : pList) {
                        i2++;
                        if (!found[i2]) {
                            int cmp = comparatorFunc.compare(p1, p2);
                            if (cmp == 0) {
                                int idx = foundIdx[i1];
                                if (idx > 0) {
                                    result.get(idx).add(p2);
                                } else {
                                    foundIdx[i1] = result.size();
                                    ArrayList<T> list = new ArrayList<T>();
                                    list.add(p1);
                                    list.add(p2);
                                    result.add(list);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    // в заданных списках Tobj оставит только с одинаковым значением comparatorFunc
    public static <CompareObj, ListOfObj> List<List<ListOfObj>> getEquals(List<List<ListOfObj>> paths, IGetPathValue<CompareObj, ListOfObj> comparatorFunc) {
        ListIterator<List<ListOfObj>> pathsIterator = paths.listIterator();
        List<List<ListOfObj>> result = new ArrayList<List<ListOfObj>>();
        while (pathsIterator.hasNext()) {
            List<ListOfObj> p1 = pathsIterator.next();
            Hashtable<CompareObj, List<ListOfObj>> ht = new Hashtable<CompareObj, List<ListOfObj>>();
            for (ListOfObj p : p1) {
                CompareObj cmp = comparatorFunc.get(p);
                if(cmp!=null) {
                    List<ListOfObj> found = ht.get(cmp);
                    if (found == null) {
                        found = new ArrayList<ListOfObj>();
                        found.add(p);
                        ht.put(cmp, found);
                    } else {
                        found.add(p);
                    }
                }
            }
            ht.forEach((k, v) -> {
                if (v.size() > 1) result.add(v);
            });
        }
        return result;
    }

    // Считываем все файлы в данном каталоге в поток
    public static List<Path> readAllPathsLambda(String startPath) throws IOException {
        return Files.walk(Paths.get(startPath))
                .filter(Files::isRegularFile) //.map(Path::toString)
                .collect(Collectors.toList());
    }

    // Считываем все файлы в данном каталоге в массив
    public static List<Path> readAllPathsNio(String startPath) {
        List<Path> result = new ArrayList<Path>();
        Path root = Paths.get(startPath);
        SimpleFileVisitor fv = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                result.add(file);
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult visitFileFailed(Path file, IOException e)
                    throws IOException {
                return FileVisitResult.SKIP_SUBTREE; // нет прав, и не надо
            }
        };
        try {
            Files.walkFileTree(root, fv);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Считываем все файлы в данном каталоге в массив
    public static List<String> readAllFilesIo(String startPath) {
        return readAllFilesIo(new File(startPath));
    }
    public static List<String> readAllFilesIo(File folder)
    {
        List<String> result = new ArrayList<String>();
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                result.addAll(readAllFilesIo(entry));
            } else {
                result.add(entry.getPath());
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(findDuplicates("c:/TEMP").toString().replace("], ", "]," + (char) 10));
    }
}