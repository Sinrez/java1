package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    static CacheInfo lastFibo;

    static class CacheInfo {
        int n;
        int fibo;
        int score;

        CacheInfo (int fibo, int score){
            this.fibo = fibo;
            this.score = score;
        }
    }
    public static int fiboNumber(int n) {
        if (lastFibo != null && n == lastFibo.score){
            return lastFibo.fibo;
        }
        int r = 1;
        int x = 0;
        int z = 0;
        for (int i = 1; i <= n; i++) {
            z = r + x;
            x = r;
            r = z;
            if (i == 1) {
                x = 0;
            }
            if (i != n) {
                lastFibo = new CacheInfo(r, i);
            }
        }
        return r;
    }


    public static void main(String[] args) {
        fiboNumber(10);
    }
}

