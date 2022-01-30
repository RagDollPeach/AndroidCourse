import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArraysHomeWork {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] array = new int[10];
        int[] giftedArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] array1 = new int[10][10];
        int[] minMaxArray = {10, 58, 32, 525, 11, 40, 155, 12, 31, 78, 82, 99, 17, 28};
        int[] forBalance = {1, 5, 9, 3, 2, 11, 6, 3};
        int[] forShift = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        feelUpArray(array);
        changeDigitsPlaces(array);

        System.out.println();
        System.out.println(Arrays.toString(simpleArray()));

        System.out.println();
        multiplyDigits(giftedArray);

        System.out.println();
        crossArray(array1);
        System.out.println();

        System.out.println(Arrays.toString(createArray(10, 5)));
        System.out.println();

        getMinAndMaxDigits(minMaxArray);
        System.out.println();
        System.out.println();

        System.out.println(getBalance(forBalance));
        System.out.println();

        System.out.println(Arrays.toString(forShift));
        shift(forShift, 6);
    }

    //=============================1============================//

    private static void feelUpArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(2);
        }
    }

    public static void changeDigitsPlaces(int[] array) {
        System.out.println(Arrays.toString(array) + " - Массив до изменений");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array) + " - Измененный массив");
    }

    //====================================2===================================//
    private static int[] simpleArray() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    //=====================================3================================//

    private static void multiplyDigits(int[] array) {
        System.out.println(Arrays.toString(array) + " - Заданный массив");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array) + " - Числа меньше 6 умножены на 2");
    }

    //=====================================4=================================//

    private static void crossArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((i + j) % (array.length - 1) == 0) {
                    array[i][j] = 1;
                } else array[i][j] = 0;
                if (i == j) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    //===================================5======================================//

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    //====================================6=====================================//

    public static void getMinAndMaxDigits(int[] array) {
        int tempMin = array[0];
        int tempMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < tempMin) {
                tempMin = array[i];
            }
            if (array[i] > tempMax) {
                tempMax = array[i];
            }
        }
        System.out.printf("Минимальное число = %d и Максимальное число = %d  ", tempMin, tempMax);
    }

    //=====================================7===================================//

    public static boolean getBalance(int[] array) {
        int arraySum = 0;
        for (int i : array) {
            arraySum += i;
        }

        int rightSum = 0;
        List<Integer> rightArraySum = new ArrayList<>(); // не придумал тут ни чего с простым массивом
        // поскольку образовывались не заполненые ячейки с нулями, пришлось использовать ArrayList

        for (int i : array) {
            if (rightSum == arraySum - rightSum) {
                print(array, rightArraySum.size());
                return true;
            } else {
                rightSum += i;
                rightArraySum.add(i);
            }
        }
        return false;
    }

    private static void print(int[] array, int limit) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if ((i + 1) == limit) {
                System.out.print("||| ");
            }
        }
        System.out.println();
    }

    //======================================8==============================================//

    public static void shift(int[] array, int move) {
        int insideMove;
        if (move > array.length) {
            insideMove = Math.abs(move % array.length);
        } else {
            insideMove = Math.abs(move);
        }
        int temp;
        if (move > 0) {
            for (int i = 0; i < insideMove; i++) {
                temp = array[0];
                array[0] = array[array.length - 1];

                for (int j = 1; j < array.length - 1; j++) {
                    array[array.length - j] = array[array.length - j - 1];
                }
                array[1] = temp;
            }
            System.out.println(Arrays.toString(array) + " Сделан сдвиг в право на " + insideMove +
                    (insideMove < 5 ? " шага" : " шагов"));
        } else {
            for (int i = 0; i < insideMove; i++) {
                temp = array[array.length - 1];
                array[array.length - 1] = array[0];

                if (array.length - 1 - 1 >= 0) {
                    System.arraycopy(array, 1, array, 0, array.length - 1 - 1);
                }
                array[array.length - 2] = temp;
            }
            System.out.println(Arrays.toString(array) + " Сделан сдвиг в лево на " + insideMove +
                    (insideMove < 5 ? " шага" : " шагов"));
        }
    }
}
