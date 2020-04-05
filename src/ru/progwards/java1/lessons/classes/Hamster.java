package ru.progwards.java1.lessons.classes;

public class Hamster extends Animal{
//            1.6  public AnimalKind getKind(), который возвращает HAMSTER.
//            1.7 public FoodKind getFoodKind(), который возвращает CORN
    @Override
    public AnimalKind getKind(){
        return AnimalKind.HAMSTER;
    }

    @Override
    public FoodKind getFoodKind(){
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff(){
        //который должен возвращать 0.03
        return 0.03;
    }
}
