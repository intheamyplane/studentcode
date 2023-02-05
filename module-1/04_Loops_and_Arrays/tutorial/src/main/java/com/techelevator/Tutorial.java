package com.techelevator;

import java.sql.SQLOutput;

public class Tutorial {

    public static void main(String[] args) {

        // write your code here
        for (int i = 0; i <= 5; i++) {
            System.out.println(i);
        }
        for (int i = 10; i >=0; i--) {
            System.out.println(i);
        }
        int[] forecastTemperatures = new int[5];

        forecastTemperatures[0] = 72;
        forecastTemperatures[1] = 78;
        forecastTemperatures[2] = 58;
        forecastTemperatures[3] = 79;
        forecastTemperatures[4] = 74;
        forecastTemperatures[2] += 10;

        for (int i=0; i < forecastTemperatures.length; i++) {
            System.out.println(forecastTemperatures[i]);
        }

        int highestTemperatureValue = forecastTemperatures[0];
        int highestTemperatureIndex = 0;


        for (int j = 1; j < forecastTemperatures.length; j++) {
            if (forecastTemperatures[j] > highestTemperatureValue) {
                highestTemperatureValue = forecastTemperatures[j];
                highestTemperatureIndex = j;
            }
        }
        System.out.println("The highest temperature is " + highestTemperatureValue);
        System.out.println("The highest temperature is in " + (highestTemperatureIndex + 1) + " days");

        int answer = 0;
        for(int i = 0; i < 10; i++) {
            if(i % 2 == 0) {
                answer = answer + 1;
            }
        }
        System.out.print(answer);





    }
}



