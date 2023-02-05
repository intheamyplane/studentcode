package com.techelevator;

public class Card {

    public static final int SPADES = 1;
    public static final int DIAMONDS = 2;
    public static final int CLUBS = 3;
    public static final int HEARTS = 4;

    //the state of my object
    private int rank;
    private int suite;
    private boolean faceDown = true;

    public Card(int rank, int suite, boolean faceDown) {
        this.rank = rank;
        this.suite = suite;
        this.faceDown = faceDown;
    }
    public Card(int rank, int suite) {
        this(rank, suite, false);
    }

    //a getter for the rank attributes
    public int getRank() {
        return rank;
    }

   // public void setRank(int rank) {
   //    this.rank = rank;
   // }

    public int getSuite() {
        return this.suite;
    }

 //   public void setSuite(int suite) {
 //       this.suite = suite;
 //   }

    public String getSuiteName() {
        if (this.suite == SPADES) {
            return "Spades";
        }
    }

    public boolean isFaceDown() {
        return this.faceDown;
    }


    public void flip() {
        this.faceDown = !this.faceDown;
    }

    public String getCardName() {
        String name = String.format("%s of %s", this.rank, this.suite);
        if (this.isFaceDown()) {
            name = "######";
        }else {
            name= String.format("%s of %s", this.rank, this.suite);
        }
        return name;
    }



}
