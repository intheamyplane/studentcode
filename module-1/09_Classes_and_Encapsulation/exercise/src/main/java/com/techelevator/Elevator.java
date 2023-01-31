package com.techelevator;

public class Elevator {
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    //getters
    public int getCurrentFloor() {
        return currentFloor;
    }
    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public boolean isDoorOpen() {
        return doorOpen;
    }


    //constructor
    public Elevator(int numberOfLevels){
        this.currentFloor=numberOfLevels;
    }

    //methods
    public void openDoor(){
        if(isDoorOpen()==false){
            doorOpen=true;
        }
    }
    public void closeDoor(){
        if(isDoorOpen()==true){
            doorOpen=false;
        }
    }
    public void goUp(int desiredFloor){
        if(isDoorOpen()==false && currentFloor<=numberOfFloors-1 && currentFloor<desiredFloor && desiredFloor<=numberOfFloors){
            currentFloor=desiredFloor;
        }
    }
    public void goDown(int desiredFloor){
        if(isDoorOpen()==false && currentFloor>=1 && currentFloor>desiredFloor){
            currentFloor=desiredFloor;
        }
    }

    //end of methods
}
