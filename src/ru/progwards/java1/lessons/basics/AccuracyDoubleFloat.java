package ru.progwards.java1.lessons.basics;

    public class AccuracyDoubleFloat {
        double r = 6371.2;


        public static double volumeBallDouble(double radius){
            //4/3πR3.
            double pi = 3.14;
            double v = 4 / 3 * pi * Math.pow(radius, 3);
            return v;
        }

        public static float volumeBallFloat(float radius){
            float pi = 3.14f;
            float v = (float) (4 / 3 * pi * Math.pow(radius, 3));
            return v;

        }

        public static double calculateAccuracy(double radius){
        float rf = (float) radius;
           double d = volumeBallDouble(radius);
           float f = volumeBallFloat(rf);
            return d - f;
        }

//        public static void main(String[] args) {
//            double r = 6371.2;
//            System.out.println(calculateAccuracy(r));
//        }

}
