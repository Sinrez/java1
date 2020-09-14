package ru.progwards.java1.lessons.test;

public class Exepts {

    public Integer sqr(Integer n){
        try {
            return (n * n);
        }
        catch (NullPointerException e){
            return -1;
        }
    }

    public static void main(String[] args) {
        Exepts exepts = new Exepts();
        System.out.println(exepts.sqr(5));

    }
}
