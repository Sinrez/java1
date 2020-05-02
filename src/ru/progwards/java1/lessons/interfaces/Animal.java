package ru.progwards.java1.lessons.interfaces;

public class Animal implements FoodCompare, Comparable, CompareWeight{
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

    private AnimalKind animalKind = AnimalKind.ANIMAL;
    private FoodKind foodKind = FoodKind.UNKNOWN;

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

    public FoodKind getFoodKind1(){
        //который возвращает вид еды, (enum FoodKind - UNKNOWN, HAY, CORN). В данном классе вернуть UNKNOWN
        return Animal.FoodKind.UNKNOWN;
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
        return 0.02D;
    }

    public double calculateFoodWeight(){
        //    который рассчитывает необходимый вес еды,
//    по формуле - вес-еды = вес-животного * коэффициент веса тела.
        return weight * getFoodCoeff();
    }

    public FoodKind getFoodKind() {
        return foodKind;
    }

    // информация о цене 1 кг еды
    public double getFood1kgPrice() {
        switch (foodKind) {
            case HAY: return 20d;
            case CORN: return 50d;
        }
        return 0d;
    }

    // возвращает информацию о цене еды для данного животного
    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    @Override
    // результаты сравнения цены еды для данного животного с ценой еды для другого животного
    public int compareFoodPrice(Animal animal) {
        return Double.compare(getFoodPrice(), animal.getFoodPrice());
    }

    @Override
    public int compareTo(Object o) {
        if (o == this) return 0;
        if (!(o instanceof Animal)) throw new RuntimeException("Object o is not inherited from Animal class.");
        double w = this.getWeight();
        double wo = ((Animal) o).getWeight();
        if (w == wo) return 0;
        if (w > wo) return 1;
        return -1;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt){
        double w = this.getWeight();
        double wo = ((Animal) smthHasWeigt).getWeight();
        if (w == wo) return CompareResult.EQUAL;
        else if (w > wo) return CompareResult.GREATER;
        else return CompareResult.LESS;
    }

    public String toStringFull(){
        //    Для класса Animal, создать метод
//    public String toStringFull(), что бы он возвращал информацию о животном в формате:
//    I am <AnimalKind>, eat <FoodKind> <CalculateFoodWeight>
        return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }
}
