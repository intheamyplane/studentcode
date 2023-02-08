package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBitsTest {
    @Test
    void nullTest(){
        var nullTester = new StringBits();
        String actual = null;
        String expected = "";
        Assert.assertEquals(expected,nullTester.getBits(actual));
    }

    @Test
    void emptyStringTest(){
        var emptyStringTester = new StringBits();
        String actual = "";
        String expected = "";
        Assert.assertEquals(expected,emptyStringTester.getBits(actual));
    }

    @Test
    void oneLetterStringTest(){
        var oneLetterStringTester = new StringBits();
        String actual = "a";
        String expected = "a";
        Assert.assertEquals(expected, oneLetterStringTester.getBits(actual));
    }

    @Test
    void happyTest(){
        var happyTester = new StringBits();
        String actual = "This is a happy test!";
        String expected = "Ti sahpyts!";
        Assert.assertEquals(expected,happyTester.getBits(actual));
    }

}
