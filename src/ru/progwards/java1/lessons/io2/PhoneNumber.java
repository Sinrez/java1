package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
    public static String format(String phone){
        String regNum = "";
        for (char sym : phone.toCharArray()) {
            if (Character.isDigit(sym))
                regNum += sym;
        }
        int len = regNum.length();
        switch (len){
            case 11:    regNum = regNum.substring(1);
            case 10:    break;
            default:
                try {
                    String kod = regNum.substring(-1);
                } catch (Exception e) {
//                    System.out.println(e.getMessage());
                    throw e;
                }
        }
        regNum = "+7(" + regNum.substring(0,3) + ")" + regNum.substring(3,6) + "-" + regNum.substring(6);
        return regNum;
    }

    public static void main(String[] args) {
        System.out.println(format("+79788286024"));
        System.out.println(format("79991112233"));
        System.out.println(format("8(999)111-22-33"));

    }
}