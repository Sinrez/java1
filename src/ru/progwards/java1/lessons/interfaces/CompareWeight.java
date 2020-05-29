package ru.progwards.java1.lessons.interfaces;

//3.1 Создать интерфейс CompareWeight
public interface CompareWeight {

    public enum CompareResult {LESS, EQUAL, GREATER};

    public CompareResult compareWeight(CompareWeight smthHasWeigt);
}