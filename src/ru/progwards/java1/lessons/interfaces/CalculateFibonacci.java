package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {

    private static CacheInfo lastFibo;

    static class CacheInfo {
        int n;
        int fibo;
    }

    public static int fiboNumber(int n) {

        lastFibo = new CacheInfo();

        if (lastFibo.n == n){
            return lastFibo.fibo;
        }

        int result;
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        if (n < 0){
            result = 0;
        } else if(n == 1 || n == 2) {
            result = 1;
        } else {
            for(int i = 3; i <= n; i++){
                n2=n0+n1;
                n0=n1;
                n1=n2;
            }
            result = n2;
        }
        lastFibo.fibo = result;
        return result;
    }


}