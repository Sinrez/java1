package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    //    3.1 конструктор
//    public ComplexNum(int a, int b), который инициализирует комплексное число
    int a; // действительная часть
    int b; // мнимая часть

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public ComplexNum newComplexNum(int a, int b) {
        return new ComplexNum(a, b);
    }

    //3.2 метод
//    public String toString(), приведение к строке, выдать в формате a+bi, например, при a=1 и b=56 должно быть выдано 1+56i
    @Override
    public String toString() {
        return a + "+" + b + "i";
    }
//3.3 метод
//    public ComplexNum add(ComplexNum num), сложение комплексных чисел по формуле:
//            (a + bi) + (c + di) = (a + c) + (b + d)i
    public ComplexNum add(ComplexNum num1, ComplexNum num2) {
        return new ComplexNum(num1.a + num2.a, num1.b + num2.b);
    }
    // вычитание комплексных чисел по формуле: (a + bi) - (c + di) = (a - c) + (b - d)i
    public ComplexNum sub(ComplexNum num1, ComplexNum num2) {
        return new ComplexNum(num1.a - num2.a, num1.b - num2.b);
    }
    // умножение комплексных чисел по формуле: (a + bi) * (c + di) = (a*c - b*d) + (b*c + a*d)i
    public ComplexNum mul(ComplexNum num1, ComplexNum num2) {
        int a = num1.a, b = num1.b, c = num2.a, d = num2.b;
        return new ComplexNum(a * c - b * d, b * c + a * d);
    }
    // деление комплексных чисел по формуле:
    //(a + bi) / (c + di) = (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
    public ComplexNum div(ComplexNum num1, ComplexNum num2) {
        int a = num1.a;
        int  b = num1.b;
        int c = num2.a;
        int d = num2.b;
        return new ComplexNum((a * c + b * d) / (c * c + d * d),
                (b * c - a * d) / (c * c + d * d));
    }

    // TEST
//    public static void main(String[] args) {
//        ComplexNum a = new ComplexNum(1, 1);
//        ComplexNum b = new ComplexNum(3, 3);
//        System.out.println(a.add(a, b));
//        System.out.println(a.sub(a, b));
//        System.out.println(a.mul(a, b));
//        System.out.println(a.div(a, b));
//    }
}
