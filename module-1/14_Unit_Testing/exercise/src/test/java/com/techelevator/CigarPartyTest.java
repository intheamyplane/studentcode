package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CigarPartyTest {

    @Test
    void notEnoughCigarsAndNotWeekend(){
        var only30CigarsNotWeekend= new CigarParty();
        assertFalse(only30CigarsNotWeekend.haveParty(30, false));
    }



}
