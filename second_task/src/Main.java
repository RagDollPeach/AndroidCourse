import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // раз уж на уроке вспомнили Роберта Мартина то попробуем сделать все по первому правилу SOLID
        int firstDigit = scanner.nextInt();
        int secondDigit = scanner.nextInt();
        String string = "Hello Java";
        int[] years = {1586, 1944, 2020, 2058, 2125};

        start(firstDigit, secondDigit);
        start2(firstDigit);
        System.out.println(positiveOrNegative(firstDigit));

        System.out.println();

        printString(string, firstDigit);

        System.out.println();

        getYears(years);
    }

    //============================1=========================================//
    public static void start(int first, int second) {
        print(checkSum(count(first, second)));
    }

    private static void print(boolean checkSum) {
        System.out.println(checkSum);
    }

    private static int count(int firstDigit, int secondDigit) {
        return firstDigit + secondDigit;
    }

    private static boolean checkSum(int sum) {
        return sum > 10 && sum <= 20;
    }

    //===========================2================================//

    public static void start2(int digit) {
        printResult(checkingDigit(digit));
    }

    private static boolean checkingDigit(int digit) {
        return digit >= 0;
    }

    private static void printResult(boolean digit) {
        if (digit) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //============================3===================================//

    public static boolean positiveOrNegative(int digit) {
        return digit < 0;
    }

    //===========================4====================================//

    private static void printString(String str, int number) {
        for (int i = 0; i < number; i++) {
            // вот этот вывод нужно мне подтянуть
            System.out.printf("%d) %s%n", (i + 1), str);
        }
    }

    //=============================5==================================//

    public static void getYears(int[] years) {
        Arrays.stream(years).forEach(Main::printLeapYear);

//        for (int year : years) {   // <- вот так тоже можно:) вдруг вы не знали ахаха ☺
//            printLeapYear(year);
//        }
    }

    private static void printLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.println("Год весокосный");
        } else {
            System.out.println("Год НЕ весокосный");
        }
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
