package ru.progwards.java1.lessons.test;

public class Rectangle {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {

        return a*b;
    }
    @Override
    public boolean equals(Object anObject){
        if (this == anObject) return true;
        if (anObject== null) return  false;
        if (getClass() != anObject.getClass())
            return false;
        Rectangle rectangle = (Rectangle) anObject;
        return Double.compare(a*b, rectangle.area()) == 0;

    }


//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
}
