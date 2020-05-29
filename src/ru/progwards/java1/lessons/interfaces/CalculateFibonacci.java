package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {

    private static CacheInfo lastFibo;

    public static int fiboNumber(int n)
    {
        lastFibo = new CacheInfo();

        if (lastFibo.n == n) return lastFibo.fibo;

        int a = 1;
        int fibo = 0;
        int counter = 0;

        while (counter++ < n) {
            int a1 = a;
            a = fibo;
            fibo += a1;
        }

        lastFibo.n = n;
        lastFibo.fibo = fibo;

        return fibo;
    }

    public static class CacheInfo
    {
        public int n;
        public int fibo;
    }

    public static CacheInfo getLastFibo(){
        return lastFibo;
    }

    public static void clearLastFibo(){
        lastFibo = null;
    }

}

