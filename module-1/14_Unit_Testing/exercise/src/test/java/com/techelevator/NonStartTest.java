package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonStartTest {
    @Test
    void oneLetterString(){
        var oneLetterTester = new NonStart();
        String a = "a";
        String b = "second";
        Assert.assertEquals("econd", oneLetterTester.getPartialString(a,b));

    }

    @Test

    void nullTest(){
        var nullTester = new NonStart();
        String a = null;
        String b = "test";

        Assert.assertEquals("est", nullTester.getPartialString(a,b));
    }

    @Test

    void happyTestWorking(){
        var happyTester = new NonStart();
        String a = "howdy";
        String b = "partna";

        Assert.assertEquals("owdyartna", happyTester.getPartialString(a,b));

    }

}
