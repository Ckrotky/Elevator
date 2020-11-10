package com.lesson3.hw2;

public class House {

    private Floor[] floors;



// Дом состоит из массива объектов (Этажей)
// Создаем массив объектов, размерностью, заданной в Main floorCount
    public House(int floorsCount) {
        floors = new Floor[floorsCount];
        for (int i = 0; i < floorsCount; i++) {
            assert this.floors != null;
            this.floors[i] = new Floor();
        }
    }

    public int getFloorsCount() {
        return getFloors().length;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public void setElevatorOnFloorAnton(int moveToFloor, Elevator elevator) {
        if (moveToFloor > 0 && moveToFloor <= floors.length) {
            floors[moveToFloor - 1].setElevator(elevator);
        } else {
            System.out.println("Given number is incorrect");
        }

        for (Floor floor : floors) {
            System.out.println(floor.showElevator());
        }
    }

    public void moveElevator(int moveToFloor, Elevator elevator) {
        for (Floor floor : floors) {
            floor.setElevator(null);
        }
        setElevatorOnFloorAnton(moveToFloor, elevator);
    }

    public int getElevatorPosition() {
        int position = 0;
        for (int i = 0; i <= getFloorsCount()-1 ; i++) {
            if (floors[i].getElevator() != null) {
                position = i+1;
                break;
            }
            position = 1;
        }
        return position;
    }

    //DRY/KISS Don't repeat yourself / Keep it simple, simple stupid
}


