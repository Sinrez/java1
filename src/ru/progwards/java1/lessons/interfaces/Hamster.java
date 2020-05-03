package ru.progwards.java1.lessons.interfaces;

public class Hamster extends Animal{
    //            1.6  public AnimalKind getKind(), который возвращает HAMSTER.
//            1.7 public FoodKind getFoodKind(), который возвращает CORN
    public Hamster(double weight) {
        super(weight);
    }

    @Override
    public Animal.AnimalKind getKind(){
        return Animal.AnimalKind.HAMSTER;
    }

    @Override
    public Animal.FoodKind getFoodKind(){
        return Animal.FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff(){
        //который должен возвращать 0.03
        return 0.03D;
    }
}
