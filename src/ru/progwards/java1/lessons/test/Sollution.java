package ru.progwards.java1.lessons.test;

public class Sollution {



    public static void showWeather(City city) {
        //напишите тут ваш код
        //city = new City(name,temperature);
        System.out.println("В городе  сегодня "+city.getName()+" сегодня температура воздуха "+city.getTemperature());
    }

    public static void main(String[] args) {
        City city = new City("Дубай", 40);
        Sollution.showWeather(city);
    }
}
