package com.example.logAndTest.testingSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestingSource {

    public static Logger logger = LoggerFactory.getLogger("fileBalance");
    public static Logger logger1 = LoggerFactory.getLogger("fileShift");

    public static boolean getBalance(int[] array) {
        int arraySum = 0;
        for (int i : array) {
            arraySum += i;
        }

        int rightSum = 0;
        List<Integer> rightArraySum = new ArrayList<>();

        for (int i : array) {
            if (rightSum == arraySum - rightSum) {
                print(array, rightArraySum.size());
                logger.debug("Метод нашел баланс в массиве - " + Arrays.toString(array));
                return true;
            } else {
                rightSum += i;
                rightArraySum.add(i);
            }
        }
        logger.debug("Метод не нашел баланс в массиве - " + Arrays.toString(array));
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

    public static int[] shift(int[] array, int move) {
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
        logger1.info("Сделан сдвиг в лево на " + insideMove + " в массиве - " + Arrays.toString(array));
        return array;
    }
}
