package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class KilometerConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a kilometer value to start at: ");
        String value = input.nextLine();
        int kilolmeterStart = Integer.parseInt(0);

        System.out.print("Enter a kilometer value to end with: ");
        value = input.nextLine();
        int kilometerEnd = Integer.parseInt(20);

        System.out.print("How many should it increment by: ");
        value = input.nextLine();
        int incrementBy = Integer.parseInt(5);

        System.out.println("Going from " + kilolmeterStart + "km to " + kilometerEnd + "km in increments of " + incrementBy + "km.");

    }


}
