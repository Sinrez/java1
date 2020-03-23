package ru.progwards.java1.lessons.basics;

    public class AccuracyDoubleFloat {
        double r = 6371.2;
        private static final float fpi = 3.14f;
        private static final double pi = 3.14;


        public static double volumeBallDouble(double radius){
            //4/3πR3.
            double v = (double)4 / 3 * pi * radius * radius * radius;
            return v;
        }

        public static float volumeBallFloat(float radius){
            float v = (float) 4 / 3 * fpi * radius * radius * radius;
            return v;

        }

        public static double calculateAccuracy(double radius) {
            return volumeBallDouble(radius) - volumeBallFloat((float) radius);
        }


//        public static void main(String[] args) {
//            double r = 6371.2;
//            float fr =6371.2f;
//            System.out.println(calculateAccuracy(r));
//            System.out.println(volumeBallDouble(r));
//            System.out.println(volumeBallFloat(fr));
//        }

}
