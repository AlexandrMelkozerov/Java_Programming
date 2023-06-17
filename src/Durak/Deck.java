package Durak;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();

        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        Rank[] ranks = {Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE};

        for (String suit : suits) {
            for (Rank rank : ranks) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card drawCard() {
        if (this.cards.size() > 0) {
            return this.cards.remove(0);
        } else {
            return null;
        }
    }

    public Card getTrumpCard() {
        Card trumpCard = null;
        if (this.cards.size() > 0) {
            // Берем последнюю карту из колоды и делаем ее козырной
            trumpCard = this.cards.get(this.cards.size() - 1);
            trumpCard.setTrump(true);
        }
        return trumpCard;
    }
}