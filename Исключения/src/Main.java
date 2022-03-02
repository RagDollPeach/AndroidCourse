import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[4][4];
        feelUpArray(arr);
        arr[2][3] = "$";
        int arraySum = arrayCheck(arr);
        print(arr, arraySum);
    }

    public static void feelUpArray(String[][] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int a = random.nextInt(10);
                arr[i][j] = Integer.toString(a);
            }
        }
    }

    public static int arrayCheck(String[][] arr) {
        int sum = 0;
        if (arr.length != 4) {
            try {
                throw new MyArraySizeException("Массив не правильного размера");
            } catch (MyArraySizeException e) {
                e.printStackTrace();
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    try {
                        int a = Integer.parseInt(arr[i][j]);
                        sum += a;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Не правельный симбол в ячейке - [" + i + "][" + j + "]" + " символ = " + arr[i][j]);
                    }
                }
            }
        }
        return sum;
    }

    public static void print(String[][] arr, int arrayDigitSum) {
        System.out.println("Массив - " + Arrays.deepToString(arr));
        System.out.println("Сумма цифр массива - " + arrayDigitSum);
    }
}
