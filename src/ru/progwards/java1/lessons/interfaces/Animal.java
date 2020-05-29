package ru.progwards.java1.lessons.interfaces;

import java.util.Objects;

public class Animal implements FoodCompare, Comparable<Animal> {
    private double weight;

    public Animal(double weight) {

        this.weight = weight;
    }

    @Override
    public int compareTo(Animal o) {
        int num = 0;
        if (this.weight < o.weight) {
            num = -1;
        }

        if (this.weight > o.weight) {
            num = 1;
        }
        return num;
    }

    enum AnimalKind {
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }

    enum FoodKind {
        UNKNOWN,
        HAY,
        CORN
    }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    @Override
    public String toString() {
        return "I am " + getKind() + ", eat " + getFoodKind();
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return 0.02;
    }

    public double calculateFoodWeight() {
        return getWeight() * getFoodCoeff();
    }

    public String toStringFull() {
        return toString() +  " " + calculateFoodWeight();
    }

    public double getFood1kgPrice() {
        double price =0;
        switch (getFoodKind()) {
            case HAY :
                price = 20;
                break;
            case CORN:
                price = 50;
                break;
            case UNKNOWN:
                price = 0;
                break;
        }
        return price;
    }

    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    @Override
    public int compareFoodPrice(Animal aminal) {
        return Double.compare(this.getFoodPrice(), aminal.getFoodPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}
