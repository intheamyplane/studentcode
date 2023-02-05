package com.techelevator;

public class Loops {
    public static void main(String[] args) {
        System.out.println(FactOFour());
        System.out.println(FactofFive());
        System.out.println(Fact(4));
    }

    private int SumofOdds(int n) {
        //looking for 1,3,7,9.....n
        int result = 0;
        for (int number = 1; number <= n; number += 2) {

            result += number;

        }
        return result;
    }

    private static int Fact(int n) {
        int counter = 1;  //initialize
        int result = 1;
        //     while (counter <= n) {    // condition
        //       result = result * counter;
        //      counter++;  // incrementing

        //       }
        result = 1;
        // initialize condition increment
        for (int c = 1; c <= n; c++) {
            result *= c;
        }
        return result;
    }

    private static int FactOFour() {
        return 4 * 3 * 2 * 1;
    }

    private static int FactofFive() {
        return 5 * 4 * 3 * 2 * 1;

    }
}
