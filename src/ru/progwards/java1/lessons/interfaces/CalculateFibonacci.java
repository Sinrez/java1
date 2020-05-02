package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {

    public static class CacheInfo{
        public int n; // - число, для которого рассчитываем Фибоначчи
        public int fibo; //- результат расчет
    }

    static CacheInfo lastFibo;
    static {
        lastFibo = new CacheInfo();
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
            lastFibo.n = n;
            lastFibo.fibo = f;
            return f;
        }
//        2.4 В статической функции fiboNumber, проверять параметр n на совпадение с последним рассчитанным значением,
//        и если совпадает - возвращать уже готовый результат.
//                Если не совпадает - рассчитывать и сохранять в статической переменной lastFibo.
    }
//    2.5 Реализовать метод public static CacheInfo getLastFibo() который возвращает lastFibo
public static CacheInfo getLastFibo(){
        return lastFibo;
}
//2.6 Реализовать метод public static void clearLastFibo(), который сбрасывает lastFibo в null
public static void clearLastFibo(){
    lastFibo = null;
}

}
