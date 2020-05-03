package ru.progwards.java1.lessons.interfaces;


public class Cow extends Animal {
    //    Реализовать класс Cow, потомок класса Animal, переопределяющий методы:
//            1.4 public AnimalKind getKind(), который возвращает COW.
//            1.5 public FoodKind getFoodKind(), который возвращает HAY
    public Cow(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind(){
        return AnimalKind.COW;
    }

    @Override
    public FoodKind getFoodKind(){
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff(){
        //который должен возвращать 0.05
        return 0.05D;
    }

}
