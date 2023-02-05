package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class histogram {
    public static void main(String[] args) {
        String result = from("you are screen sharing");
    }

    public static String from(String str) {
       Map<String, Integer> counts = new HashMap<>();
        for(int i=0;i<str.length(); i++) {
           String letter = str.substring(i, i+1);
           int currentCount = 0;
           if(counts.containsKey(letter)) {
               currentCount = counts.get(letter);
           }
           counts.put(letter, currentCount+1);
           }
        return null;
        }
    }

