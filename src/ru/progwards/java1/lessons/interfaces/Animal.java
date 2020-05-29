package ru.progwards.java1.lessons.interfaces;

public class Animal implements FoodCompare, CompareWeight, Comparable<Animal>{

    public enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK};
    public enum FoodKind {UNKNOWN, HAY, CORN};
    private double weight;

    public Animal(double weight)
    {
        this.weight = weight;
    }

    public AnimalKind getKind()
    {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind()
    {
        return FoodKind.UNKNOWN;
    }

    public String toString()
    {
        return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }

    public double getWeight()
    {
        return weight;
    }

    public double getFoodCoeff()
    {
        return 0.02;
    }

    public double calculateFoodWeight()
    {
        return weight * getFoodCoeff();
    }

    public boolean equals(Object o)
    {
        if (!o.getClass().equals(Animal.class) && !o.getClass().getSuperclass().equals(Animal.class)) return false;

        Animal a = (Animal)o;
        if (this.getWeight() == a.getWeight())
        {
            if (this.getKind() == a.getKind())
            {
                return true;
            }
        }

        return false;
    }

    public double getFood1kgPrice()
    {
        switch (getFoodKind())
        {
            case HAY:
                return 20D;
            case CORN:
                return 50D;
            case UNKNOWN:
                return 0D;
        }
        return 0D;
    }

    public double getFoodPrice()
    {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    @Override
    public int compareFoodPrice(Animal animal) {
        return Double.compare(this.getFoodPrice(), animal.getFoodPrice());
    }

    @Override
    public int compareTo(Animal o) {
        if (this.getWeight() < o.getWeight()) return -1;
        else if (this.getWeight() > o.getWeight()) return 1;
        else return 0;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        if (this.getWeight() < ((Animal)smthHasWeigt).getWeight()) return CompareWeight.CompareResult.LESS;
        else if (this.getWeight() > ((Animal)smthHasWeigt).getWeight()) return CompareWeight.CompareResult.GREATER;
        else return CompareWeight.CompareResult.EQUAL;
    }
}
