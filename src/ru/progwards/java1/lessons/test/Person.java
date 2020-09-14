package ru.progwards.java1.lessons.test;

public class Person {

    public String name;
    Person(String name) {
        this.name = name;
    }

//    public static class Child1{
//        String hello(){
//            return "привет";
//        }
//    }
//
//    public class Child2{
//        String hello(){
//            return "servus";
//        }
//    }

//    вложенный класс Child1
//    внутренний класс Child2
//    У каждого класса, Child1 и Child2 создайте метод String hello()
//
//    У Child1 String hello() должен вернуть "привет"
//    У Child2 String hello() должен вернуть "servus"
//
//public static void main(String[] args) {
//    Child1 child1 = new Child1();
//    System.out.println(child1.hello());
//
//    Person person = new Person();
//    Person.Child2 child2 = person. new Child2();
//    System.out.println(child2.hello());
//
//}

    Person p = new Person("Вася");
   // someFunction(p);



}
