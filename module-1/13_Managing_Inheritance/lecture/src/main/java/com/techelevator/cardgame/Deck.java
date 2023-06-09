package com.techelevator.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck() {


        for (Suite suite : suites) {
            for (Rank rank : ranks) {
                Card c = new Card(rank, suite, false);
                this.cards.add(c);
            }
        }
    }

    public List<Card> getDeck() {
        return this.cards;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

}
