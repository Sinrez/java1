package ru.progwards.java1.lessons.bigints;


abstract class AbsInteger {

    AbsInteger () {
    }
    @Override
    public String toString(){
        return null;
    }

    public int absValue() {
        return 0;
    }



    public
    static AbsInteger add(AbsInteger num1, AbsInteger num2){
        int res = num1.absValue() + num2.absValue();
        if (res >= Byte.MIN_VALUE && res <= Byte.MAX_VALUE){
            return  new ByteInteger((byte) res);
        }
        if (res >= Short.MIN_VALUE && res <= Short.MAX_VALUE){
            return  new ShortInteger ((short) res);
        }
        return new IntInteger(res);
    }

    public static void main(String[] args) {
        AbsInteger num1 = new ByteInteger((byte) 100);
        AbsInteger num2 = new ShortInteger((short) 500);
        System.out.println(add(num1, num2).toString());
        System.out.println();

    }
}
