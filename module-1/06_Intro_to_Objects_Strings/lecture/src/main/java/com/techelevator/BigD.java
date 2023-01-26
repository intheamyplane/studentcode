package com.techelevator;

import java.math.BigDecimal;

public class BigD {
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("3.14");
        System.out.println(bd1);
        System.out.println(bd1.add(BigDecimal.ONE));
        System.out.println(bd1.subtract(BigDecimal.ONE));
        System.out.println(bd1.multiply(BigDecimal.TEN));
        System.out.println(bd1.divide(BigDecimal.TEN));
    }
}
