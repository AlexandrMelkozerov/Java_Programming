package Durak;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private boolean attacker;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.attacker = false; // Изначально игрок не является атакующим
    }

    public void setAttacker(boolean attacker) {
        this.attacker = attacker;
    }

    public boolean isAttacker() {
        return this.attacker;
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

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getAttackCards(Card trumpCard) {
        ArrayList<Card> attackCards = new ArrayList<Card>();
        for (Card card : this.hand) {
            if (card != null && !Card.isTrump(card, trumpCard)) {
                attackCards.add(card);
            }
        }
        return attackCards;
    }

    public boolean hasAttackCard(Card trumpCard) {
        for (Card card : this.hand) {
            if (card.getRank() != Rank.ACE && card.getRank() != Rank.KING && card.getRank().compareTo(trumpCard.getRank()) < 0) {
                return true;
            }
        }
        return false;
    }
    public boolean hasCard(Card card) {
        return this.hand.contains(card);
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
            Card defendCard = defendCards.get(choice - 1);

            // Проверяем, есть ли выбранная карта у игрока
            if (this.hasCard(defendCard)) {
                return defendCard;
            } else {
                System.out.println("Invalid choice. Try again.");
                return chooseDefendCard(attackCard, trumpCard);
            }
        }
    }
}

