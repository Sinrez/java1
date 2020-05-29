package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    static CacheInfo lastFibo = new CacheInfo();


    public static int fiboNumber(int n) {
        if (n == CalculateFibonacci.lastFibo.n) {
            return CalculateFibonacci.lastFibo.fibo;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int a = 1;
        int b = 1;
        int f = 0;
        for (int i = 2; i < n; i++) {
            f = a + b;
            a = b;
            b = f;
        }

        CalculateFibonacci.lastFibo.n = n;
        CalculateFibonacci.lastFibo.fibo = f;

        return f;
    }

    static class CacheInfo {
        int n;
        int fibo;
    }

    public static void main(String[] args) {
        CalculateFibonacci calculateFibonacci = new CalculateFibonacci();
        System.out.println(CalculateFibonacci.lastFibo.n);
        System.out.println(CalculateFibonacci.lastFibo.fibo);
        System.out.println(CalculateFibonacci.fiboNumber(10));
    }
}

