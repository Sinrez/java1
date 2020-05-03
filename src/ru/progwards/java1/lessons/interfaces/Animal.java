package ru.progwards.java1.lessons.interfaces;

import java.util.Objects;

public class Animal implements FoodCompare, Comparable<Animal>{

    private double weight;
    private double weightCoeff = 0.02D;

    enum AnimalKind{
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }
    enum FoodKind{
        UNKNOWN,
        HAY,
        CORN
    }

    public Animal(){
    }

    public Animal(double weight){
        this.weight = weight;
    }

    public AnimalKind getKind(){
        //public AnimalKind getKind(),
        // который возвращает вид животного (enum AnimalKind - ANIMAL, COW, HAMSTER, DUCK).
        // В данном классе вернуть ANIMAL
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind(){
        //который возвращает вид еды, (enum FoodKind - UNKNOWN, HAY, CORN). В данном классе вернуть UNKNOWN
        return FoodKind.UNKNOWN;
    }

    public String toString(){
        //который возвращает информацию о животном в формате:
        //I am <AnimalKind>, eat <FoodKind>
        return "I am "+getKind()+", "+"eat "+getFoodKind();
    }

    public double getWeight(){
        //который возвращает вес животного
        return weight;
    }

    public double getFoodCoeff(){
        //который возвращает коэффициент веса еды к весу тела животного.
        // Для класса Animal это 0.02
        return weightCoeff;
    }

    public double calculateFoodWeight(){
        //    который рассчитывает необходимый вес еды,
//    по формуле - вес-еды = вес-животного * коэффициент веса тела.
        return getWeight() * getFoodCoeff();
    }

    public String toStringFull(){
        //    Для класса Animal, создать метод
//    public String toStringFull(), что бы он возвращал информацию о животном в формате:
//    I am <AnimalKind>, eat <FoodKind> <CalculateFoodWeight>
        return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.weight, weight) == 0;
    }

    public double getFood1kgPrice() {
        switch (getFoodKind()){
            case HAY: return 20;
            case CORN: return 50;
            default: return 0;
        }
    }

    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    @Override
    public int compareFoodPrice(Animal animal) {
        return Double.compare(getFoodPrice(), animal.getFoodPrice());
    }

    @Override
    public int compareTo(Animal animal) {
        if (getWeight() < animal.getWeight()) {
            return -1;
        }
        else if (getWeight() > animal.getWeight()){
            return 1;
        }
        else {
            return 0;
        }
    }
}
