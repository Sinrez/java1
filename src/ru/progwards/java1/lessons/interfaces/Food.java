package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight{

    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    public int getWeight()
    {
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        if (this.getWeight() < ((Food)smthHasWeigt).getWeight()) return CompareWeight.CompareResult.LESS;
        else if (this.getWeight() > ((Food)smthHasWeigt).getWeight()) return CompareWeight.CompareResult.GREATER;
        else return CompareWeight.CompareResult.EQUAL;
    }

}