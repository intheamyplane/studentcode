package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalGroupNameTest {

   @Test
    void rhinoIsCrashWithCapitalLetter(){
        var rhinoCrash = new AnimalGroupName();
        assertEquals("Crash", rhinoCrash.getHerd("Rhino"));
    }

}
