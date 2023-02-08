package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordCountTest {
    @Test
    void nullTest(){
        var nullTester = new WordCount();
        String[] actual = null;
        Map<String, Integer> expected = new HashMap<>();
        Assert.assertEquals(expected,nullTester.getCount(actual));


    }

    @Test
    void emptyArrayTest(){
        var emptyArrayTester = new WordCount();
        String[] actual = new String[0];
        Map<String, Integer> expected = new HashMap<>();
        Assert.assertEquals(expected,emptyArrayTester.getCount(actual));

    }






}
