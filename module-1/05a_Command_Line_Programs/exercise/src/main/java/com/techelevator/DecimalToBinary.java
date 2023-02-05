//package com.techelevator;
//
//import java.util.Scanner;
//
//public class DecimalToBinary {
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Please enter in a series of decimal values (separated by spaces):");
//        String value = input.nextLine();
//
//        String[] values = value.split(" ");
//		for(String value : values) {
//			int decValue = Integer.parseInt(value);
//			String result = "";
//			while (decValue > 0) {
//				result = decValue % 2 + result;
//				decValue/= 2;
//			}
//			System.out.printf("%s => %s\n", value, result);
//		}
//
//
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
