package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalGroupNameTest {

   @Test
    void rhinoIsCrashWithCapitalLetter(){
        var rhinoCrash = new AnimalGroupName();
        assertEquals("Crash", rhinoCrash.getHerd("Rhino"));
    }
    @Test
    void nullTest(){
       var nullTest = new AnimalGroupName();
       assertEquals("unknown", nullTest.getHerd(null));
    }

    @Test
    void unlistedAnimal(){
       var unlistedAnimal= new AnimalGroupName();
       assertEquals("unknown", unlistedAnimal.getHerd("pikachu"));
    }

}
