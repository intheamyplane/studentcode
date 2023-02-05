package com.techelevator.cardgame;

import java.util.HashMap;
import java.util.Map;

public class Card {



    // the state of my object
    private int rank;
    private int suite;
    private boolean faceDown = true;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
        this.faceDown = false;
    }

    public Card(Rank rank, Suite suite, boolean faceDown) {
        this(rank, suite);
        this.faceDown = faceDown;
    }

    // a getter for the rank attribute
    public Rank getRank() {
        return this.rank;
    }



    public Suite getSuite() {
        return this.suite;
    }

    // this is not complete
    public String getSuiteName() {
        if (this.suite == SPADES) {
            return "Spades";
        }
        return "Clubs";
    }


    public boolean isFaceDown() {
        return this.faceDown;
    }

    public void flip() {
        this.faceDown = !this.faceDown;
    }

    public String getCardName() {
        String name="";
        if (this.isFaceDown()) {
            name = "##########";
        } else {
            name = String.format("%s of %s", this.rank, this.suite);
        }
        return name;
    }
}
