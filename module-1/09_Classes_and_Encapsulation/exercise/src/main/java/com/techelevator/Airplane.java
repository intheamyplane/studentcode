package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;



    //getters
    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {

        int availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
        return availableFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        int availableCoachSeats = totalCoachSeats - bookedCoachSeats;
        return availableCoachSeats;
    }


    //constructor
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;

    }

    //method


    public boolean reserveSeats(boolean forFirstClass, int totalNumberSeats) {


        if(forFirstClass){
            if(this.getAvailableFirstClassSeats()<totalNumberSeats) {
                return false;
            }else{
                this.bookedFirstClassSeats+=totalNumberSeats;
                return true;
                }

        }else {
            if (this.getAvailableCoachSeats()<totalNumberSeats) {
                return false;
            } else {
                this.bookedCoachSeats += totalNumberSeats;
                return true;
            }
        }







    }
    //end of method


}
