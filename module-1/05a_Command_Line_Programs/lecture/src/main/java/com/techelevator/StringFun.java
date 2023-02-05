package com.techelevator;

import java.util.Locale;

public class StringFun {
    public static void main(String[] args) {
        int p = 0; //< created a datatype of integer
        String hello = "hello";
        String hello2 = "hello";
        String world = "world";
        String expected = "hello world";
        String full = hello + " " + world;
        System.out.println(hello == hello2); //works due to String Interning
        System.out.println(expected == full); //doest work because points to diff things in heap
        System.out.println(expected.equals(full)); //compare strings with .equals() method FTW
        System.out.println(expected.equalsIgnoreCase(full));

        String words = "one,two,three,four";  //functionality exists to where you can split on any char to make array from string
        String wordsArr[] = words.split(",");
        for (int i = 0; i < wordsArr.length; i++) {
            System.out.println(wordsArr[i]);
        }

        String allUpper = expected.toUpperCase();
        System.out.println("allUpper= " + allUpper);
        System.out.println("expected= " + expected);

        String one = "1";
        // int total = 4-one; wont work
        int total = 4 - Integer.parseInt(one);
        System.out.println("the result is: " + total);

        double ten = 10;
        Double tenWrapper = 10.0;  // capital D double is an OBJECT
        double backToTen = tenWrapper;

    }
}
