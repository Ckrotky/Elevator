package com.lesson3.hw2;

// Класс Floor
public class Floor {
    private Elevator elevator;

    public Floor() {
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }


    public String showElevator(){
    String elevatorValue;
    if (elevator!=null){
        elevatorValue = "X";
    } else {
        elevatorValue = " ";
    }
    return "["+elevatorValue+"]";
    }


    public Elevator getElevator() {
         return elevator; // Prev value
    }
}