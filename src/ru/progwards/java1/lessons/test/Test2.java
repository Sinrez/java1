package ru.progwards.java1.lessons.test;

import java.util.*;

public class Test2 {
//    public static void iSetTest() {
//        Set<Integer> iSet = new HashSet<>();
//        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++) {
//                iSet.add(i+j);
//            }
//        System.out.println(iSet.size());
//    }

//    public static void wSetTest() {
//        String TEXT = "на дворе трава на траве дрова не руби дрова на траве двора";
//        Set<String> wordSet = new HashSet<>(Arrays.asList(TEXT.split(" ")));
//
//        Iterator<String> iter = wordSet.iterator();
//        while (iter.hasNext())
//            if (iter.next().contains("ра"))
//                iter.remove();
//
//        System.out.println(wordSet.size());
//    }

//    public static void cset() {
//        Set<Integer>  fiboSet1000 =
//                Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987);
//        int sum = 0;
//        for (int i = 2; i < 10; i++)
//            sum += fiboSet1000.contains(i) ? 1 : 0;
//        System.out.println(sum);
//    }

//    public Set<Integer> a2set(int[] a)

//    public static void unionOfSets(final Set set1, final Set set2) {
//        HashSet result = new HashSet(set1);
//        result.addAll(set2);
//        System.out.println(result.size());
//    }

//    public static void doTreeSet() {
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        treeSet.add(9);
//        treeSet.add(1);
//        treeSet.add(5);
//        treeSet.add(2);
//        treeSet.add(4);
//        treeSet.add(8);
//
//        String s = "";
//        Iterator<Integer> iterator = treeSet.descendingIterator();
//        while (iterator.hasNext())
//            s += iterator.next();
//        System.out.println(s);
//    }

    public static void doTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(19);
        treeSet.add(12);
        treeSet.add(15);
        treeSet.add(10);

        String s = "";
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
            s += iterator.next();
        System.out.println(s);
    }

//
        public static void main (String[]args){
        doTreeSet();
            //Test2.iSetTest();
            //Test2.wSetTest();
//        Test2.cset();
//            Set<Integer> intSet1 = Set.of(1, 3, 5, 12, 45);
//            Set<Integer> intSet2 = Set.of(12, 44, 2, 1, 4);
//            unionOfSets(intSet1, intSet2);

        }

}
