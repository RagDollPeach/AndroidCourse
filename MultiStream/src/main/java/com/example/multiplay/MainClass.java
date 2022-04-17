package com.example.multiplay;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static boolean checkingWinner = true;
    public static final int CARS_COUNT = 4;
    public static CountDownLatch finish = new CountDownLatch(CARS_COUNT);
    public static CountDownLatch start = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {

        System.out.println(ANSI_YELLOW + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!" + ANSI_RESET);

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        ExecutorService exs = Executors.newFixedThreadPool(cars.length);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            exs.execute(car);
        }

        start.await();
        System.out.println(ANSI_GREEN + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!" + ANSI_RESET);
        finish.await();
        System.out.println(ANSI_RED + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!" + ANSI_RESET);

        exs.shutdown();
    }
}
