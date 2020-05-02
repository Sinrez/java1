package ru.progwards.java1.lessons.interfaces;

public class ArraySort implements CompareWeight {

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt){
//        double w = this.getWeight();
//        double wo = ((Animal) smthHasWeigt).getWeight();
//        if (w == wo) return CompareResult.EQUAL;
//        else if (w > wo) return CompareResult.GREATER;
//        else return CompareResult.LESS;
        return null;
    }

        public static void sort(CompareWeight[] a){
            CompareWeight z;
            for(int i = 0; i < a.length; i++){
                for (int j = i + 1; j < a.length; j++){
                    if (a[j].compareWeight((CompareWeight) a[i]) == CompareResult.GREATER){
                        z = a[i];
                        a[i] = a[j];
                        a[j] = z;
                    }
                }
            }
        }

    public static void main(String[] args) {
    }
}

