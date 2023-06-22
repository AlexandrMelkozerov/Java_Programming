package Durak;

import Durak.Rank;

import java.util.ArrayList;

public class Card {
    private String suit;
    private Rank rank;
    private boolean isTrump;

    public Card(String suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public static boolean isTrump(Card card, Card trumpCard) {
        if (card.getSuit() == trumpCard.getSuit() || card.getRank() == trumpCard.getRank()) {
            return true;
        }
        return false;
    }

    public ArrayList<Card> getAttackCards(Player player, Card trumpCard) {
        ArrayList<Card> attackCards = new ArrayList<Card>();
        for (Card card : player.getHand()) {
            if (card != null && !Card.isTrump(card, trumpCard)) {
                attackCards.add(card);
            }
        }
        return attackCards;
    }

    public String getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public boolean beats(Card otherCard, Card trumpCard) {
        if (this.getSuit().equals(otherCard.getSuit())) {
            // Если у обеих карт одинаковый масть
            return this.getRank().compareTo(otherCard.getRank()) > 0;
        } else if (this.getSuit().equals(trumpCard.getSuit())) {
            // Если у текущей карты козырная масть
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.rank.toString() + " of " + this.suit;
    }

    public void setTrump(boolean isTrump) {
        this.isTrump = isTrump;
    }
}