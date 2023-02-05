package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final double METERS_TO_FEET = 3.2808399;
		final double FEET_TO_METERS = 0.3048;


		System.out.println("Please enter the length.");
		String value = input.nextLine();
		double lengthEntered = Double.parseDouble(value);

		System.out.println("Is the length in (m)eters or (f)eet?");
		String value2 = input.nextLine();

		if(value2.equals("m")) {
			double lengthFeet = (lengthEntered*METERS_TO_FEET);
			System.out.println(lengthEntered + "m is " + lengthFeet + "f.");
		} else {
			double lengthMeters = lengthEntered*FEET_TO_METERS;
			System.out.println(lengthEntered + "f is " + lengthMeters + "m. ");
		}


	}

}
