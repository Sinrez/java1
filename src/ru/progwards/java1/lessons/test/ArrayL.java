
import java.util.Arrays;
import java.util.ArrayList;


/*
Переворачивание данных
*/
public class ArrayL {
    //public static int[] numbers1 = new int[10];

    public static ArrayList<Integer> numbers  = new ArrayList<Integer>();


    public static void main(String[] args) {
        init();
        print();

        reverse();
        print();
    }

    public static void init() {


        for (int i = 0; i < 10; i++) {
            // numbers[i] = i;

            numbers.add(i);
        }
    }

    public static void reverse() {
        for(int i = 0, j = numbers.size() - 1; i < j; i++) {
            numbers.add(i, numbers.remove(j));
        }


    }

    private static void print() {

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
