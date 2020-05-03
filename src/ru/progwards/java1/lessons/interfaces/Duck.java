package ru.progwards.java1.lessons.interfaces;

public class Duck extends Animal {
    //    1.8 public AnimalKind getKind(), который возвращает DUCK.
////            1.9 public FoodKind getFoodKind(), который возвращает CORN
    public Duck(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind(){
        return AnimalKind.DUCK;
    }

    @Override
    public FoodKind getFoodKind(){
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff(){
        //который должен возвращать 0.04
        return 0.04D;
    }
}
