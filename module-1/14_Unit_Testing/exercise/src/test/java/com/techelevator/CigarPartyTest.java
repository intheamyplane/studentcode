package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CigarPartyTest {

    @Test
    void notEnoughCigarsAndNotWeekend(){
        var only30CigarsNotWeekend= new CigarParty();
        assertFalse(only30CigarsNotWeekend.haveParty(30, false));
    }

    @Test
    void tooManyCigarsWeekday(){
        var cigars70OnWeekday = new CigarParty();
        assertFalse(cigars70OnWeekday.haveParty(70, false));
    }
    @Test

    void tooManyCigarsWeekend(){
        var cigars70Weekend = new CigarParty();
        assertTrue(cigars70Weekend.haveParty(70, true));
    }
    @Test

    void notEnoughCigarsWeekend(){
        var only30CigarsWeekend = new CigarParty();
        assertFalse(only30CigarsWeekend.haveParty(30, true));
    }

}
