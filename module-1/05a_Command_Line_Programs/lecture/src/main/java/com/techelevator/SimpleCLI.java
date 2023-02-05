package com.techelevator;

import java.util.Scanner;

public class SimpleCLI {
    public static void main(String[] args) {  // what you type in command line after "git" shows up in string array calls "args"
        final Scanner userInput = new Scanner(System.in); // final indicates to java that this variable cannot be changed again

       // prompt the user for their name
        System.out.println("what is your name");

        // read the name from the keyboard
        String name = userInput.nextLine();

        String greeting = "hello " + name;

        System.out.println(greeting);

    }
}
