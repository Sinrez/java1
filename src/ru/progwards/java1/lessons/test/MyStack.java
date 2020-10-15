package ru.progwards.java1.lessons.test;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private final List<String> storage = new ArrayList<>();

        public void push(String s) {
            //напишите тут ваш код
            storage.add(0, s);
        }

        public String pop() {
            //напишите тут ваш код
            return storage.remove(0);
        }

        public String peek() {
            //напишите тут ваш код
            return storage.get(0);
        }

        public boolean empty() {
            //напишите тут ваш код
            return storage.isEmpty();
        }

//        public int search(String s) {
//            //напишите тут ваш код
//            int n = 0;
//            for (int i = 0; i < storage.size(); i++){
//                if(storage.get(i).equals(s)){
//                    n = i;
//                } else {
//                    n = -1;
//                }
//            }return n;
//        }
    public int search(String s) {
       return storage.indexOf(s);
            }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("Test1");
        myStack.push("Test2");
        myStack.push("Test3");
        myStack.push("Test4");

        for (String s : myStack.storage){
            System.out.println(s);
        }


        System.out.println(myStack.search("Test4"));


    }

}


