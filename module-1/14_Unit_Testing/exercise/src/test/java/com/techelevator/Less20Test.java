package com.techLelevator;

import com.techelevator.Less20;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Less20Test {

    @Test
    void negNumberTest(){
        var negNumber = new Less20();

        Assert.assertFalse(negNumber.isLessThanMultipleOf20(-1));
    }

    @Test
    void tooFarFrom20(){
        var farFrom20 = new Less20();
        Assert.assertFalse(farFrom20.isLessThanMultipleOf20(17));
    }

    @Test
    void is20(){
        var is20=new Less20();
        Assert.assertFalse(is20.isLessThanMultipleOf20(20));
    }

    @Test
    void oneLessThanMultiple(){
        var oneLess = new Less20();
        Assert.assertTrue(oneLess.isLessThanMultipleOf20(59));
    }

    @Test

    void twoLessThanMultiple(){
        var twoLess = new Less20();
        Assert.assertTrue(twoLess.isLessThanMultipleOf20(58));
    }





}
