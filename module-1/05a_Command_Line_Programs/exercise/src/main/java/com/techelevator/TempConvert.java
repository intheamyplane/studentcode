package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the temperature.");
		String value = input.nextLine();
		double tempEntered = Double.parseDouble(value);

		System.out.println("Is the temperature in (C)elsius or (F)ahrenheit?");
		String value2 = input.nextLine();

		if(value2.equals("F")){
			double tempCelsius = ((tempEntered-32)/1.8);
			System.out.println(tempEntered + "F is " + tempCelsius + "C.");
		} else {
			double tempFahrenheit = tempEntered*1.8+32;
			System.out.println(tempEntered + "C is " + tempFahrenheit + "F. ");
		}

	}

}
