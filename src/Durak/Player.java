package Durak;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }
    public int getNumCards() {
        return this.hand.size();
    }
    public String getName() {
        return this.name;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public void removeCard(Card card) {
        this.hand.remove(card);
    }

    public void showHand() {
        System.out.println(this.name + "'s hand:");

        for (Card card : this.hand) {
            System.out.println("- " + card.getRank() + " of " + card.getSuit());
        }
    }

    public boolean hasAttackCard(Card trumpCard) {
        for (Card card : this.hand) {
            if (card.getRank() != Rank.ACE && card.getRank() != Rank.KING && card.getRank().compareTo(trumpCard.getRank()) < 0) {
                return true;
            }
        }
        return false;
    }

    public Card chooseAttackCard(Card trumpCard) {
        ArrayList<Card> attackCards = new ArrayList<>();
        for (Card card : this.hand) {
            if (card.getRank() != Rank.ACE && card.getRank() != Rank.KING && card.getRank().compareTo(trumpCard.getRank()) < 0) {
                attackCards.add(card);
            }
        }

        System.out.println("Choose card to attack:");
        for (int i = 0; i < attackCards.size(); i++) {
            System.out.println((i + 1) + ": " + attackCards.get(i));
        }

        int choice = InputHelper.getIntegerInput(1, attackCards.size());
        return attackCards.get(choice - 1);
    }

    public Card chooseDefendCard(Card attackCard, Card trumpCard) {
        ArrayList<Card> defendCards = new ArrayList<>();
        for (Card card : this.hand) {
            if (card.beats(attackCard, trumpCard)) {
                defendCards.add(card);
            }
        }

        if (defendCards.isEmpty()) {
            System.out.println("You can't beat " + attackCard.toString() + ". Take cards.");
            return null;
        } else {
            System.out.println("Choose card to defend:");
            for (int i = 0; i < defendCards.size(); i++) {
                System.out.println((i + 1) + ": " + defendCards.get(i));
            }

            int choice = InputHelper.getIntegerInput(1, defendCards.size());
            return defendCards.get(choice - 1);
        }
    }
}