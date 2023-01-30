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
        this.currentFloor=1;
    }

    //methods
    public void openDoor(){
        if(this.isDoorOpen()==false){
            this.doorOpen=true;
        }
    }
    public void closeDoor(){
        if(this.isDoorOpen()==true){
            this.doorOpen=false;
        }
    }
    public void goUp(int desiredFloor){
        if(this.isDoorOpen()==false&&this.currentFloor<=this.numberOfFloors-1&&this.currentFloor<desiredFloor){
            this.currentFloor=desiredFloor;
        }
    }
    public void goDown(int desiredFloor){
        if(isDoorOpen()==false&&this.currentFloor>=1&&this.currentFloor>desiredFloor){
            this.currentFloor=desiredFloor;
        }
    }

    //end of methods
}
