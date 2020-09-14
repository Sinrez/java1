package ru.progwards.java1.lessons.test;

import java.util.Arrays;


public class Calcul{

    public interface Speaking {
        public String say();
    }

    public interface Eating {
        public String eat();
    }
//    реализовать 2 класса, Dog и Goat.
//    У класса Dog метод say() должен вернуть "Гав"
//    У класса Dog метод eat() должен вернуть "Мясо"
//    У класса Goat метод say() должен вернуть "Мее"
//    У класса Goat метод eat() должен вернуть "Сено"

    public  class Dog implements Speaking, Eating{

        @Override
        public String say(){
            return "Гав";
        }

        @Override
        public String eat(){
            return "Мясо";
        }
    }

    public class Goat implements Speaking, Eating{

        @Override
        public String say(){
            return "Мее";
        }

        @Override
        public String eat(){
            return "Сено";
        }
    }

//    public static void main(String[] args) {
//        Dog dog = new Dog();
//        System.out.println(dog.say());
//    }

    }

//    Написать программный код,
//    который возвращает младший (нулевой) бит переменной byte value. Ответ нужно поместить в переменную int result.
//
//    Таким образом, если младший бит параметра value равен 0,
//    то result должен быть равен 0. Если младший бит равен 1, то и result должен быть равен 1.
//
//    byte value = (byte) 0b10101110;
//    byte check = ;
//    int result = value & (byte) 0b00000001;
//
//    public static void main(String[] args) {
//    System.out.println(result);
//}
//enum Grade {VERYBAD, BAD, SATISFACTORILY, GOOD, EXCELLENT, NOTDEFINED}
//static Grade intToGrade(int grade){
//
//    switch (grade){
//    case 1:
//    return Grade.VERYBAD;
//    case 2:
//    return Grade.BAD;
//    case 3:
//    return Grade.SATISFACTORILY;
//    case 4:
//    return Grade.GOOD;
//    case 5:
//    return Grade.EXCELLENT;
//    default:
//    return Grade.NOTDEFINED;
//}
//}
//
//    public static void main(String[] args) {
//        System.out.println(intToGrade(1));
//    }

//    Соответствие оценок
//
//1 - VERYBAD
//2 - BAD
//3 - SATISFACTORILY
//4 - GOOD
//5 - EXCELLENT
//    все остальное NOTDEFINED
    //Например, intToGrade(4) должно вернуть GOOD

