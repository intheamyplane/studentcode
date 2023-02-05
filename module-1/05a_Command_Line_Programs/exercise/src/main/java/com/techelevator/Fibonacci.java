package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Please enter a number.");
        String value = input.nextLine();
        int numEntered = Integer.parseInt(value);



        System.out.println("0,1");
        int a=0;
        int b=1;
        int next = 0;
        while(next<numEntered) {
            next= a + b;
            System.out.println(" , " +next);
            a= b;
            b = next;
        }


    }
}




