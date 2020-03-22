package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static boolean containsDigit(int number, int digit){
        //которая будет возвращать true, если число number содержит цифру digit.
        if (number >= 0 && number <= 9 && number == digit){
            return true;
        } else {
            while (number > 0 ) {
                if (number % 10 == digit){
                    return true;
                }
                number = number / 10;
            }
            return false;
        }

    }
    public static int fiboNumber(int n){
//        которая будет возвращать n-ое
//        число Фибоначчи (нумерация начинается с 1,
//        то есть при n = 3 должно вернуться число Фибоначчи 2, а при n = 10 число 55).
        int a = 1;
        int b = 0;
        int f = 0;

        if ( n == 1 || n == 2){
            return 1;
        } else {
            for (int i = 0; i < n; i++){
                f = a + b;
                a = b;
                b = f;
                //System.out.println(f);
            }

        return f;
        }
    }

    public static boolean isGoldenTriangle(int a, int b, int c){
        //которая будет возвращать true, если треугольник со сторонами a, b, c является Золотым.
//    Он должен быть равнобедренным и отношение ребра к основанию должно лежать между значениями 1.61703 и 1.61903.
        boolean ret = false;

        double v1 = 1.61703;
        double v2 = 1.61903;

        double ab = (double) (a) / (double) (c);
        double ac = (double) (a) / (double) (b);
        double bc = (double) (b) / (double) (a);

        if (TriangleInfo.isIsoscelesTriangle(a,b,c)) {
            if (ab >= v1 && ab <= v2 || ac >= v1 && ac <= v2  || bc >= v1 && bc <= v2 ){
                ret = true;
            }
        } else { ret = false;}
            return ret;
    }

    public static void main(String[] args) {
//        System.out.println(containsDigit(44546, 4));
        //System.out.println(fiboNumber(10));
     //   System.out.println(isGoldenTriangle(55,34,55));
        for (int i = 0; i < 15; i++){
            System.out.println(fiboNumber(i));
        }
//После этого, используя вложенные циклы, определить: есть ли среди треугольников,
// длины сторон которых являются натуральными числами не превышающими 100,
// Золотые треугольники. И если есть, вывести на консоль длины основания и рёбер этих треугольников.
    for (int i = 0; i < 100; i++){
        for (int j = 0; j < 100; j++){
                if (isGoldenTriangle(i, j, i)){
                    System.out.printf(i + " " + j + " "+i );
                }
        }
    }

    }

    }

