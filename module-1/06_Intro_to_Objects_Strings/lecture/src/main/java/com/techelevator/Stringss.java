package com.techelevator;

public class Stringss {
    public static void main(String[] args) {
        String fx = new String("my Value");
        String hello = "hello world";

        //length- in an array, its values in the array, for a string, the length is the num of characters in string- spaces are also considered characters in a string

        System.out.println(hello.length());


        //SUBSTRINGS
        System.out.println(hello.substring(6));  //return "world"
        System.out.println(hello.substring(6,7)); //returns "w"
        System.out.println(hello.substring(6, hello.length()));

    //    for(int i=0; i < hello.length(); i++) {
    //        System.out.println(hello.substring(i,i+1));
    //    }

        // indexOf
        System.out.println(hello.indexOf("world"));
        System.out.println(hello.indexOf("o"));
        System.out.println(hello.indexOf("o", 5));
        System.out.println(hello.indexOf("not found")); //-1 if it's not found

    }

}
