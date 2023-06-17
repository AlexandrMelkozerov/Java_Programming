package Durak;

import java.util.ArrayList;

public class Game {
    private Deck deck;
    private ArrayList<Player> players;
    private int currentPlayerIndex;

    public Game() {
        this.deck = new Deck();
        this.players = new ArrayList<Player>();
        this.currentPlayerIndex = 0;
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

    public void play() {
        while (!hasWinner()) {
            Player currentPlayer = this.players.get(this.currentPlayerIndex);
            System.out.println(currentPlayer.getName() + "'s turn:");
            Card trumpCard = deck.getTrumpCard();

            // Проверяем, может ли игрок атаковать
            if (currentPlayer.hasAttackCard(trumpCard)) {
                Card attackCard = currentPlayer.chooseAttackCard(trumpCard);
                System.out.println(currentPlayer.getName() + " attacks with " + attackCard.toString());
                for (Player defender : players) {
                    if (defender != currentPlayer) {
                        // Запрашиваем у защитника карту для защиты
                        Card defendCard = defender.chooseDefendCard(attackCard, trumpCard);
                        if (defendCard != null) {
                            System.out.println(defender.getName() + " defends with " + defendCard.toString());
                            if (defendCard.beats(attackCard, trumpCard)) {
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