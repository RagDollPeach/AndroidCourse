import java.util.ArrayList;
import java.util.List;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(-45, 30);
        printColor(50);
        compareNumbers(10,9);
    }

    private static void printThreeWords() {
        List<String> list = new ArrayList<>();
        list.add("Orange");
        list.add("Banana");
        list.add("Apple");
        list.add("так чуть интересней :)");
        list.forEach(System.out::println);
    }

    private static void checkSumSign(int a, int b) {
        int result = a + b;

        if (result >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрецательное");
        }
    }

    private static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
