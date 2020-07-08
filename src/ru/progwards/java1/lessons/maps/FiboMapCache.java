package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    private Map<Integer, BigDecimal> fiboCache;
    private boolean cacheOn;
    //  При cacheOn = true кэш работает, при cacheOn = false - выключен
    public FiboMapCache(boolean cacheOn){   //  конструктор
        fiboCache = new HashMap<>();    //  хранилище расчитанных значений
        this.cacheOn = cacheOn;         //  признак использования кэша
    }
    public void clearCahe(){
        fiboCache.clear();
    }
    //  проверить, находится ли вычисленное значение для n в кэше
    public BigDecimal fiboNumber(int n){
        BigDecimal result = BigDecimal.ZERO;
        if (cacheOn)    // кэш работает, проверить наличие
            if (fiboCache.containsKey(n))       //  значение ключа найдено
                result = fiboCache.get(n);
            else {
                result = fibonacci(n);          //  расчитать новое число
                fiboCache.put(n, result);       //  поместить результат в кэш
            }
        else
            result = fibonacci(n);
        return result;
    }
    //  рассчет числа Фибоначчи для n
    static BigDecimal fibonacci(int n){
        BigDecimal f_n_2 = BigDecimal.ZERO;  //  F[n-2]
        BigDecimal f_n_1 = BigDecimal.ONE;  //  F[n-1]
        BigDecimal f_n = BigDecimal.ONE;    //  F[n]
        for (int i = 2; i <= n; i++){
            f_n = f_n_2.add(f_n_1); //  f_n = f_n_2 + f_n_1;
            f_n_2 = f_n_1;
            f_n_1 = f_n;
        }
        return f_n;
    }
    public static void test(){  //   тест для расчета чисел Фибоначчи от n = 1 до 1000 включительно
        FiboMapCache test1 = new FiboMapCache(false);
        long start1 = System.currentTimeMillis();
        for (int i=1; i<=1000; i++)
            test1.fiboNumber(i);
        System.out.println("fiboNumber cacheOn = false время выполнения = " + (System.currentTimeMillis() - start1));

        FiboMapCache test2 = new FiboMapCache(true);
        long start2 = System.currentTimeMillis();
        for (int i=1; i<=1000; i++)
            test2.fiboNumber(i);
        System.out.println("fiboNumber cacheOn = true время выполнения = " + (System.currentTimeMillis() - start2));

    }
    public static void main(String[] args) {
//        System.out.println(fibonacci(10));
        test();
    }
}
//  package ru.progwards.java1.lessons.interfaces;
//  public class CalculateFibonacci
//  public static int fiboNumber(int n)