package com.lesson3.hw2;

import java.util.Scanner;

public class Menu {
    //Инициализирум Константы для цвета для сообщений
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";


    public int floorCount;

    public void showInputFloorMessage() {
        System.out.println(YELLOW + "===========================\nВведите количество этажей\n" +
                "===========================" + RESET);
        Scanner scanner = new Scanner(System.in);
        // проверяем, является ли целочисоленным
        if (scanner.hasNextInt()) {
            floorCount = scanner.nextInt();
            // Проверяем количество этажей - не вылазят ли они за пределы границ
            if (floorCount <= 10 && floorCount > 1) {
                showPult();
            } else {
                System.out.println(RED + "===========================\n!!! Количество этажей должно \nбыть более 1 и менее 10\n" +
                        "===========================" + RESET);
                showInputFloorMessage();
            }
        } else {
            System.out.println(RED + "Этаж должен состоять из числа!" + RESET);
            showInputFloorMessage();
        }
    }



    public void showPult() {
        int selectedMenu;
        System.out.println(BLUE + "===========================\n[1]\tMove to\n" +
                "[2]\tWhere the elevator\n" +
                "[3]\tExit\n" +
                "===========================" + RESET);
        Scanner scanner = new Scanner(System.in);
        // проверяем, является ли целочисоленным
        if (scanner.hasNextInt()) {
            selectedMenu = scanner.nextInt();
            // Проверяем количество этажей - не вылазят ли они за пределы границ
            if (selectedMenu <= floorCount && floorCount > 1) {

            } else {
                System.out.println(RED + "===========================\n!!! Количество этажей должно \nбыть более 1 и менее 10\n" +
                        "===========================" + RESET);
                showInputFloorMessage();
            }
        } else {
            System.out.println(RED + "Этаж должен состоять из числа!" + RESET);
            showInputFloorMessage();
        }
    }


}

