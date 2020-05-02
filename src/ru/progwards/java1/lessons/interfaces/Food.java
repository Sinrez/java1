package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight{
    private int weight;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        int w = this.getWeight();
        int wo = ((Food) smthHasWeigt).getWeight();
        if (w == wo) return CompareResult.EQUAL;
        else if (w > wo) return CompareResult.GREATER;
        else return CompareResult.LESS;
    }

    public static void main(String[] args) {
        Food food = new Food();
        food.setWeight(5);
        System.out.println(food.getWeight());
        Food food2 = new Food();
        food2.setWeight(7);
        System.out.println(food2.getWeight());

        System.out.println(food.compareWeight(food2));
    }
}
