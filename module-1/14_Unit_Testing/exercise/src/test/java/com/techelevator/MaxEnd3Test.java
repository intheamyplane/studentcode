package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxEnd3Test {
    @Test
    void firstIntHighest(){
        var firstIntHighestTester = new MaxEnd3();
        int[]actual = new int[] {7,3,5};
        int[]expected= new int[]{7,7,7};
        Assert.assertArrayEquals(expected,firstIntHighestTester.makeArray(actual));

    }

    @Test
    void lastIntHighest(){
     var lastIntHighestTester = new MaxEnd3();
     int[]actual = new int[]{2,4,8};
     int[]expected = new int[]{8,8,8};
     Assert.assertArrayEquals(expected, lastIntHighestTester.makeArray(actual));
    }

}
