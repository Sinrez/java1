package  ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {

    private boolean[] sieve;

    public Eratosthenes(int N){
//        который должен разместить массив sieve с размером в N
//        и заполнить его значениями true, после чего вызвать метод sift()
        sieve = new boolean[N];
        Arrays.fill(sieve, true);
        sift();
    }

    private void sift(){
//        реализует алгоритм Эратосфена, просеивая составные числа.
//        Подсказка - нужно реализовать 2 вложенных цикла, внешний,
//        например по i от 2 до N-1, и внутренний,
//                например по j который будет просеивать числа, кратные переменной внешнего цикла i*j.
        for(int j = 2; j*j <= sieve.length - 1; j++)
        {
            if(sieve[j] == true)
            {
                for(int i = j*2; i <= sieve.length - 1; i += j)
                    sieve[i] = false;
            }
        }

    }

    // 1.4 Реализовать метод
    // public boolean isSimjle(int n), который возвращает sieve[n],
    // что бы можно было узнать, простое число n или составное
    public boolean isSimple(int n){

        return sieve[n];
    }

//    public static void main(String[] args) {
//        Eratosthenes eratosthenes = new Eratosthenes(7);
//        System.out.println(eratosthenes.isSimple(3));
//        System.out.println(eratosthenes.isSimple(4));
//
//    }

}
