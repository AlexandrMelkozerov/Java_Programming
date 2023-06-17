package Durak;
import Durak.Rank;
public class Card {
    private String suit;
    private Rank rank;
    private boolean isTrump;

    public Card(String suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
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