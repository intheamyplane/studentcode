package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SameFirstLastTest {
    @Test
    void emptyArray(){
        var emptyArrayTester = new SameFirstLast();
        int[] empty = new int[0];
        Assert.assertFalse(emptyArrayTester.isItTheSame(empty));

    }

    @Test
    void firstLastEqual(){
        var firstLastEqualTester = new SameFirstLast();
        int[] equal = new int[]{3,5,8,7,4,3};
        Assert.assertTrue(firstLastEqualTester.isItTheSame(equal));
    }

    @Test
    void firstLastNotEqual(){
        var firstLastNotEqualTester = new SameFirstLast();
        int[] notEqual = new int[] {2,5,4,7,6};
        Assert.assertFalse(firstLastNotEqualTester.isItTheSame(notEqual));
    }

    @Test
    void nullTest(){
        var nullTester = new SameFirstLast();
        int[] nullVar = null;
        Assert.assertFalse(nullTester.isItTheSame(nullVar));
    }



}
