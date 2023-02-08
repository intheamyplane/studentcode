package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrontTimesTest {

    @Test
    void repeatTwice(){

        var repeatTwiceTester = new FrontTimes();
       Assert.assertEquals("chocho", repeatTwiceTester.generateString("chocolate", 2));
    }

    @Test
    void nullTest(){
        var nullTester = new FrontTimes();
        Assert.assertEquals("", nullTester.generateString(null, 3));

    }

    @Test
    void smallString(){
        var smallStringTester = new FrontTimes();
        Assert.assertEquals("kikiki", smallStringTester.generateString("ki", 3) );
    }





}
