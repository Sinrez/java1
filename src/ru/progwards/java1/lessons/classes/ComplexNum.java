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

//    public ComplexNum newComplexNum(int a, int b) {
//        return new ComplexNum(a, b);
//    }

    //3.2 метод
//    public String toString(), приведение к строке, выдать в формате a+bi, например, при a=1 и b=56 должно быть выдано 1+56i
    @Override
    public String toString() {
        return a + "+" + b + "i";
    }
    // сложение комплексных чисел по формуле:
// (a + bi) + (c + di) = (a + c) + (b + d)i
    public ComplexNum add(ComplexNum num)
    { return  new ComplexNum(a + num.a, b + num.b);
    }

    // вычитание комплексных чисел по формуле:
// (a + bi) - (c + di) = (a - c) + (b - d)i
    public ComplexNum sub(ComplexNum num){
        return new ComplexNum(a - num.a, b - num.b );}

    // умножение комплексных чисел по формуле:
// (a + bi) * (c + di) = (a*c - b*d) + (b*c + a*d)i
//return new ComplexNum((a * num.a) - (b * num.b), (b * num.a) + (a * num.b));
    public ComplexNum mul(ComplexNum num) {
        int с1 = (a * num.a) - (b * num.b);
        int с2 = (b * num.a) + (a * num.b);
        ComplexNum sumc =  new ComplexNum(с1, с2);
        return sumc;
    }

    public ComplexNum div(ComplexNum num){

        int vb = ((a * num.a) + (b * num.b)) / ((num.a * num.a) + (num.b * num.b));
        int cvb = ((b * num.a) - (a * num.b)) / ((num.a * num.a) + (num.b * num.b));
        ComplexNum sdd =  new ComplexNum(vb, cvb);
        return sdd;
    }

//    public static void main(String[] args) {
//        ComplexNum n1 = new ComplexNum(15, 4);
//        ComplexNum n2 = new ComplexNum(45, 54);
//        ComplexNum complexNum = new ComplexNum(5, 6);
//        System.out.println(complexNum.mul(n1));
//}

    }

