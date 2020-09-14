package ru.progwards.java1.lessons.test;

public class JRtest2 {

    /*
    Magic 8 ball
    */


        public static void main(String[] args) {
            System.out.println("Заработаю ли я себе на BMW?");
            System.out.println(generateNumber());
        }

        public static String generateNumber() {
            int answ = (int) (Math.random() * 7);
            String a = null;
            if (answ == 0){
                a = "Бесспорно";
            } else if (answ == 1){
                a=  "Определённо да";
            } else if (answ == 2){
                a = "Вероятнее всего";
            } else if (answ == 3){
                a = "Хорошие перспективы";
            } else if (answ == 4){
                a = "Спроси позже";
            } else if (answ == 5){
                a = "Попробуй снова";
            } else if (answ == 6){
                a = "Мой ответ — нет";
            } else if (answ == 7){
                a = "Весьма сомнительно";
            } else if (answ == 8){
                a = null;
            } return a;
        } }

//public class Solution {
//    public double x = 0.;
//    public double y = .0;
//    public double z = 100D;
//    public double  d = 100.0;
//    public double  e = 1.11E5;
//    public float f = 200F;
//    public float i = 0.F;
//}
//
//public class Solution {
//    public static String first = "u004A";
//    public static char second = a;
//    public static String third = "\u0076";
//    public static char fourth = {a};
//
//    public static void main(String[] args) {
//        System.out.print(first);
//        System.out.print(second);
//        System.out.print(third);
//        System.out.print(fourth);
//    }
//}
