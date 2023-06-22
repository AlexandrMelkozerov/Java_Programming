package Durak;

import java.util.ArrayList;

public class Game {
    private Deck deck;
    private ArrayList<Player> players;
    private int currentPlayerIndex;
    private Card trumpCard;
    private Player attacker;

    public Game() {
        this.deck = new Deck();
        this.players = new ArrayList<Player>();
        this.currentPlayerIndex = 0;
        this.trumpCard = this.deck.drawCard();
    }


    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void dealCards(int numCards) {
        for (int i = 0; i < numCards; i++) {
            for (Player player : this.players) {
                Card card = this.deck.drawCard();

                if (card != null) {
                    player.addCard(card);
                }
            }
        }
    }
    public Player getAttacker() {
        for (Player player : this.players) {
            if (player.isAttacker()) {
                return player;
            }
        }
        return null;
    }
    public Player getWinner() {
        for (Player player : this.players) {
            if (player.getNumCards() == 0) {
                return player;
            }
        }
        return null;
    }
    public Player getCurrentPlayer() {
        if (this.attacker == null) {
            return this.players.get(0);
        } else {
            int index = this.players.indexOf(this.attacker) + 1;
            if (index >= this.players.size()) {
                index = 0;
            }
            return this.players.get(index);
        }
    }
    public Card getLastAttackCard() {
        for (Player player : this.players) {
            for (Card card : player.getAttackCards(this.trumpCard)) {
                if (card != null) {
                    return card;
                }
            }
        }
        return null;
    }

    public void defend(Card attackCard, Card defendCard) {
        Player defender = getPlayerWithCard(defendCard);
        defender.addCard(attackCard);
        defender.addCard(defendCard);
        getPlayerWithCard(attackCard).removeCard(attackCard);
        getPlayerWithCard(attackCard).removeCard(defendCard);
    }

    private Player getPlayerWithCard(Card card) {
        for (Player player : this.players) {
            if (player.hasCard(card)) {
                return player;
            }
        }
        return null;
    }
    public ArrayList<Player> getPlayers() {
        return this.players;
    }
    public Card getTrumpCard() {
        return this.trumpCard;
    }


    public void play() {
        while (!hasWinner()) {
            Player currentPlayer = this.players.get(this.currentPlayerIndex);
            System.out.println(currentPlayer.getName() + "'s turn:");

            // Проверяем, может ли игрок атаковать
            if (currentPlayer.hasAttackCard(this.trumpCard)) {
                Card attackCard = currentPlayer.chooseAttackCard(this.trumpCard);
                System.out.println(currentPlayer.getName() + " attacks with " + attackCard.toString());
                for (Player defender : players) {
                    if (defender != currentPlayer) {
                        // Запрашиваем у защитника карту для защиты
                        Card defendCard = defender.chooseDefendCard(attackCard, this.trumpCard);
                        if (defendCard != null) {
                            System.out.println(defender.getName() + " defends with " + defendCard.toString());
                            if (defendCard.beats(attackCard, this.trumpCard)) {
                                // Если карта защитника бьет атакующую карту, то карта переходит к защитнику
                                defender.addCard(attackCard);
                                defender.addCard(defendCard);
                                currentPlayer.removeCard(attackCard);
                                currentPlayer.removeCard(defendCard);
                                break;
                            } else {
                                // Если карта защитника не может побить карту атакующего, то ход переходит к следующему игроку
                                System.out.println(defendCard.toString() + " can't beat " + attackCard.toString());
                            }
                        }
                    }
                }
            } else {
                // Иначе игрок берет карту и ход переходит к следующему игроку
                Card card = this.deck.drawCard();
                if (card != null) {
                    currentPlayer.addCard(card);
                    System.out.println(currentPlayer.getName() + " takes " + card.toString());
                }
            }

            this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.players.size();
        }

        System.out.println("The game is over!");
    }

    private boolean hasWinner() {
        for (Player player : players) {
            if (player.getNumCards() == 0) {
                System.out.println(player.getName() + " has won the game!");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = new Player("Alexandr");
        Player player2 = new Player("Yuri");
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.dealCards(6);
        game.play();
    }
}