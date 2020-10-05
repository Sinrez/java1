package ru.progwards.java1.lessons.test;

/*
Двигатель — сердце автомобиля
*/

public class Car {
    //напишите тут ваш код
    static  Engine engine;

    public static void main(String[] args) {
        //напишите тут ваш код
        Car.engine = new  Car.Engine();
        Car.engine.start();
        //System.out.println(engine.isRunning);
        Car.engine.stop();
        //System.out.println(engine.isRunning);
    }

    //напишите тут ваш код
    public static class Engine{

        private boolean isRunning;

        public void start(){
            isRunning = true;
        }

        public void stop(){
            isRunning = false;
        }
    }
}