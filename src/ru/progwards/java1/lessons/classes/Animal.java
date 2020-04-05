package ru.progwards.java1.lessons.classes;

public class Animal {

    private double weight;
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
        return 0.02;
    }

    public double calculateFoodWeight(){
        //    который рассчитывает необходимый вес еды,
//    по формуле - вес-еды = вес-животного * коэффициент веса тела.
        return weight * getFoodCoeff();
    }

    public String toStringFull(){
        //    Для класса Animal, создать метод
//    public String toStringFull(), что бы он возвращал информацию о животном в формате:
//    I am <AnimalKind>, eat <FoodKind> <CalculateFoodWeight>
        return toString() +" "+ calculateFoodWeight();
    }
}
