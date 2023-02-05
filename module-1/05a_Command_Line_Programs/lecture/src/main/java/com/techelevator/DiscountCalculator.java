package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");


        String discountAsString = scanner.nextLine(); //added scanner
        double discount = Double.parseDouble(discountAsString)/100;  //convert from string to double  (added /100 to make up for whole number later)



        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");


        String priceInput = scanner.nextLine();
        String [] pricesAsString = priceInput.split(" ");  //splits input on the space to make array

        for(int i=0; i< pricesAsString.length; i++) {
            double price = Double.parseDouble(pricesAsString[i]);  //for loop added due to array, goes through each element of array and parses them as double
            double discountedPriced = price * (1-discount);
            System.out.println(price + " discounted to " + discountedPriced);
        }







    }

}
