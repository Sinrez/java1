package ru.progwards.java1.lessons.bitsworld;

public class Binary {

    private byte num;

    //    3.1 Реализовать конструктор
//    public Binary(byte num).
    public Binary(byte num){
        this.num = num;
    }
//            3.2 Реализовать метод
//    public String toString(), который возвращает двоичное представление числа типа byte,
//    используя только битовые операции. В выводимом значении всегда должно быть 8 символов
    // не понятно как тут использовать битовые операции
    @Override
    public String toString(){
            String gf = Integer.toBinaryString(num);
            int gfLength = gf.length();
           gf = "00000000" + gf;
            return gf.substring(gfLength);

}

    public static void main(String[] args) {
        System.out.println(new Binary((byte) -1).toString());
//        0: "00000000"
//        1: "00000001"
//        127: "01111111"
//                -128: "10000000"
//                -1: "11111111"
    }

}
