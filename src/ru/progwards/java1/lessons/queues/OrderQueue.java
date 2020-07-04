package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

class Order {
    static int num1 = 1; // номер по порядку
    private double sum; // сумма заказа
    private int num; // номер по порядку

    public Order(double sum) {
        this.sum = sum;
        this.num = num1++;
    }

    public double getSum() {
        return sum;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return sum + "(" + num + ")";
    }
}

public class OrderQueue {
/*
2.5 Создать класс OrderQueue
2.6 Разместить в нем очередь с приоритетом
2.7 Создать метод, public void add(Order order), размещающий заказы в очередь с приоритетом, разбивая их по 3-м классам
3 - заказы до 10000 руб включительно
2 - заказы от 10000 до 20000 руб включительно
1 - заказы от 20000 руб
2.8 Создать метод, public Order get(), возвращающий первый заказ в очереди для обслуживания.
В начале обслуживаются заказы класса 1, потом 2, потом 3. Внутри каждого класса заказы должны
обслуживаться в порядке поступления. Метод не выбрасывает исключения, возвращает null в случае пустой очереди.
Продумать, и, при необходимости, добавить в классы нужные методы, для того, чтобы реализовать эту задачу.
*/

    Comparator<Order> orderComparator = new Comparator<Order>() {
        @Override
        public int compare(Order c1, Order c2) {
            int cl1 = ((int) c1.getSum() - 1) / 10000 + 1;
            if (cl1 < 1) cl1 = 1;
            else if (cl1 > 3) cl1 = 3;
            int cl2 = ((int) c2.getSum() - 1) / 10000 + 1;
            if (cl2 < 1) cl2 = 1;
            else if (cl2 > 3) cl2 = 3;
            if (cl1 == cl2) return c1.getNum() - c2.getNum();
            return cl2 - cl1;
        }
    };

    PriorityQueue<Order> queue = new PriorityQueue<Order>(16, orderComparator);

    public void add(Order order) {
        queue.add(order);
    }

    public Order get() {
        return queue.poll();
    }

    public Order getNum() {
        return queue.poll();
    }

    public static void main(String[] args) {
        OrderQueue oq = new OrderQueue();
        oq.add(new Order(11100.0));
        oq.add(new Order(26206.0));
        oq.add(new Order(11274.0));
        oq.add(new Order(1892.0));
        oq.add(new Order(25531.0));
        oq.add(new Order(6996.0));
        oq.add(new Order(1135.0));
        oq.add(new Order(12454.0));
        oq.add(new Order(8186.0));
        oq.add(new Order(16585.0));
        oq.add(new Order(15326.0));
        oq.add(new Order(23366.0));
        oq.add(new Order(17812.0));
        oq.add(new Order(20811.0));
        oq.add(new Order(19808.0));
        oq.add(new Order(12714.0));
        oq.add(new Order(10281.0));
        oq.add(new Order(14527.0));
        oq.add(new Order(27423.0));
        oq.add(new Order(12659.0));
        oq.add(new Order(23425.0));
        oq.add(new Order(22312.0));
        oq.add(new Order(5979.0));
//26206.0(2), 25531.0(5), 23366.0(12), 20811.0(14), 27423.0(19), 23425.0(21), 22312.0(22), 11100.0(1), 11274.0(3), 12454.0(8), 16585.0(10), 15326.0(11), 17812.0(13), 19808.0(15), 12714.0(16), 10281.0(17), 14527.0(18), 12659.0(20), 1892.0(4), 6996.0(6), 1135.0(7), 8186.0(9), 5979.0(23).
        Order o = oq.get();
        while (o != null) {
            System.out.println(o);
            o = oq.get();
        }
    }
}
