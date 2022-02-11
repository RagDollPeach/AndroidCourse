package game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static int SIZE;
    private static char[][] GAME_FIELD;
    private static Scanner scanner;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    public static void game() {
        setGameField();
        gameStart();
    }

    public static void gameStart() {
        initGameField();
        printGameField();
        while (true) {
            humanTurn();
            if (isGameOver(DOT_X)) {
                printWinner(DOT_X);
                break;
            }
            computerTurn();
            if (isGameOver(DOT_O)) {
                printWinner(DOT_O);
                break;
            }
        }
        if (restart()) {
            game();
        } else {
            System.out.println("До скорого!");
        }
    }

    private static void printWinner(char playerSight) {
        if (playerSight == DOT_X) {
            System.out.println("Человек победил жалкую машину!!!");
        } else {
            System.out.print("Востание машин близко, ИИ победил");
        }
    }

    private static void setGameField() {
        System.out.println("Введите размер игрового поля");
        scanner = new Scanner(System.in);
        int playerSize = scanner.nextInt();
        while (!(playerSize > 2 && playerSize < 7)) {
            System.out.println("Введите число от 3 до 6");
            playerSize = scanner.nextInt();
        }
        SIZE = playerSize;
    }

    private static boolean restart() {
        System.out.println("Хотите продолжить? y/n , д/н");
        scanner = new Scanner(System.in);
        return switch (scanner.nextLine()) {
            case "y", "д" -> true;
            default -> false;
        };
    }

    private static void initGameField() {
        GAME_FIELD = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                GAME_FIELD[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printGameField() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(GAME_FIELD[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkCellValidation(int x, int y) {
        boolean result = false;

        if (x > SIZE || y > SIZE) {
            return false;
        }
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            result = true;
        }
        if (GAME_FIELD[x][y] != DOT_EMPTY) {
            result = false;
        }
        return result;
    }

    private static void humanTurn() {
        System.out.println("Ход игрока:");

        int x, y;
        scanner = new Scanner(System.in);
        while (true) {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            if (checkCellValidation(x, y)) {
                GAME_FIELD[x][y] = DOT_X;
                printGameField();
                break;
            } else {
                System.out.println("Введите правельные координаты");
            }
        }
    }

    private static void computerTurn() {
        System.out.println("Ход компьютера");
        int x, y;
        Random random = new Random();
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!checkCellValidation(x, y));
        GAME_FIELD[x][y] = DOT_O;
        printGameField();
    }

    private static boolean isGameFieldFull() {
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (GAME_FIELD[i][j] == DOT_EMPTY) {
                    result = false;
                    break;
                }
            }
            if (!result) {
                break;
            }
        }
        return result;
    }

    private static boolean isGameOver(char playerSight) {
        boolean result = false;

        if (checkLines(playerSight) || checkDiagonals(playerSight)) {
            return true;
        }
        if (isGameFieldFull()) {
            System.out.println("Поле заполнено , ничья");
            result = true;
        }
        return result;
    }

    private static boolean checkDiagonals(char playerSight) {
        boolean result = false, x = true, y = true;

        for (int i = 0; i < SIZE; i++) {
            x &= (GAME_FIELD[i][i] == playerSight);
            y &= (GAME_FIELD[i][SIZE - 1 - i] == playerSight);
        }

        boolean a = false, b = false;
        if (SIZE == 4) {
            a = true;
            b = true;
            for (int i = 0; i < SIZE - 1; i++) {
                a &= (GAME_FIELD[i + 1][i] == playerSight) || (GAME_FIELD[i][i + 1] == playerSight);
                b &= (GAME_FIELD[i][SIZE - 2 - i] == playerSight) || (GAME_FIELD[i + 1][SIZE - 1 - i] == playerSight);
            }
        }
        if (x || y || a || b) {
            result = true;
        }
        return result;
    }

    private static boolean checkLines(char playerSight) {
        boolean result = false, x, y;

        for (int i = 0; i < SIZE; i++) {
            x = true;
            y = true;
            for (int j = 0; j < SIZE; j++) {
                x &= (GAME_FIELD[i][j] == playerSight);
                y &= (GAME_FIELD[j][i] == playerSight);
            }
            if (x || y) {
                result = true;
                break;
            }
        }
        return result;
    }
}
