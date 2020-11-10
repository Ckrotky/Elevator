package com.lesson3.hw2;

import java.util.Scanner;

public class Main {

    //Инициализирум Константы для цвета для сообщений
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";


    private static int floorCount;



    public static void showInputFloorMessage() {
        System.out.println(YELLOW + "===========================\nInput count of floors\n" +
                "===========================" + RESET);
        Scanner scanner = new Scanner(System.in);
        // проверяем, является ли целочисоленным
        if (scanner.hasNextInt()) {
            floorCount = scanner.nextInt();
            // Проверяем количество этажей - не вылазят ли они за пределы границ
            if (floorCount <= 10 && floorCount > 1) {
                House house = new House(floorCount);
                Elevator elevator = new Elevator();

                showPult(house, elevator);
            } else {
                System.out.println(RED + "===========================\n!!! The count of floors should be \nmore then 1 and less 10\n" +
                        "===========================" + RESET);
                showInputFloorMessage();
            }
        } else {
            System.out.println(RED + "Floor must be a number!" + RESET);
            showInputFloorMessage();
        }
    }


    public static void moveToFloor(Elevator elevator, House house) {
        System.out.println("Input floor:");
        Scanner scanner = new Scanner(System.in);
        // проверяем, является ли целочисоленным
        if (scanner.hasNextInt()) {
            int floor = scanner.nextInt();
            if (floor <= floorCount && floor >= 1) {
                house.moveElevator(floor, elevator);
            } else {
                System.out.println("Inputed floor should be more 1 and less " + floorCount);
                moveToFloor(elevator, house);
            }
        } else {
            System.out.println("Floor should be a number");
            moveToFloor(elevator, house);
        }
    }


    public static void showPult(House house, Elevator elevator) {
        int selectedMenu;
        System.out.println(BLUE + "===========================\n[1]\tMove to\n" +
                "[2]\tWhere the elevator\n" +
                "[3]\tExit\n" +
                "===========================" + RESET);
        Scanner scanner = new Scanner(System.in);
        // проверяем, является ли целочисоленным
        if (scanner.hasNextInt()) {
            selectedMenu = scanner.nextInt();
            // Проверяем корректность введенного пункта - должет быть не менее 1 и не более 3
            if (selectedMenu <= 3 && selectedMenu >= 1) {
                // Проверяем количество этажей - не вылазят ли они за пределы границ
                switch (selectedMenu) {
                    case 1:
                        moveToFloor(elevator, house);
                        showPult(house, elevator);
                        break;
                    case 2:
                        System.out.println(house.getElevatorPosition());
                        showPult(house, elevator);
                    case 3:
                        System.exit(1);
                        default:
                        showPult(house, elevator);
                        break;
                }

            } else {
                System.out.println(RED + "Menu item should be more 1 and less 3!" + RESET);
                showPult(house, elevator);
            }
        }
    }

    public static void main(String[] args) {
        showInputFloorMessage();

    }
}

