package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateFashionTest {

    @Test
    void youVeryStylishDateNoStyle(){
        var youStylishDateNot = new DateFashion();

        Assert.assertEquals(0, youStylishDateNot.getATable(10,2));
    }

    @Test

    void bothMidStyle(){
        var midStyleCouple = new DateFashion();
        Assert.assertEquals(1, midStyleCouple.getATable(5,5));
    }

    @Test
    void youMidDateVeryStylish() {
        var dateHasDrip = new DateFashion();
        Assert.assertEquals(2, dateHasDrip.getATable(7,9));


    }


}
