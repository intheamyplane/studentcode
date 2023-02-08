package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class Lucky13Test {
    @Test
    void nullTest(){
        var nullTester = new Lucky13();
        Assert.assertTrue(nullTester.getLucky( null));

    }

    @Test
    void noLucky(){
        var noLuckyTester = new Lucky13();
        int[] noLuckyArray = new int [] {2,4,7};
        Assert.assertTrue(noLuckyTester.getLucky(noLuckyArray));
    }

    @Test
    void veryLucky(){
        var veryLuckyTester = new Lucky13();
        int[] veryLucky = new int[] {1,3,5};
        Assert.assertFalse(veryLuckyTester.getLucky(veryLucky));
    }



}
