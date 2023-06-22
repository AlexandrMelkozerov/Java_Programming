package Durak;

import javax.swing.*;
import java.awt.*;

public class DurakGUI {
    private JFrame frame;
    private JPanel playerPanel;
    private JPanel buttonPanel;
    private JButton attackButton;
    private JButton defendButton;
    private JLabel currentPlayerLabel;

    private Game game;
    private Player currentPlayer;

    public DurakGUI() {
        // Создаем игру и добавляем игроков
        this.game = new Game();
        Player player1 = new Player("Александр");
        Player player2 = new Player("Юрий");
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.dealCards(6);

        // Создаем главное окно и панели для отображения игроков и кнопок
        this.frame = new JFrame("Дурак");
        this.playerPanel = new JPanel(new GridLayout(2, 1));
        this.buttonPanel = new JPanel(new GridLayout(1, 2));
        this.attackButton = new JButton("Атаковать");
        this.defendButton = new JButton("Защититься");
        this.currentPlayerLabel = new JLabel();

        // Добавляем компоненты на панели
        //this.playerPanel.add(player1HandPanel);
        //this.playerPanel.add(player2HandPanel);
        this.buttonPanel.add(this.attackButton);
        this.buttonPanel.add(this.defendButton);

        // Добавляем панели на главное окно
        this.frame.setLayout(new BorderLayout());
        this.frame.add(this.playerPanel, BorderLayout.CENTER);
        this.frame.add(this.buttonPanel, BorderLayout.SOUTH);

        // Устанавливаем обработчики событий для кнопок
        this.attackButton.addActionListener(e -> {
            // Вызываем метод атаки для текущего игрока
            if (this.currentPlayer.hasAttackCard(game.getTrumpCard())) {
                Card attackCard = this.currentPlayer.chooseAttackCard(game.getTrumpCard());
                for (Player defender : game.getPlayers()) {
                    if (defender != currentPlayer) {
                        Card defendCard = defender.chooseDefendCard(attackCard, game.getTrumpCard());
                        if (defendCard != null) {
                            if (defendCard.beats(attackCard, game.getTrumpCard())) {
                                defender.addCard(attackCard);
                                defender.addCard(defendCard);
                                currentPlayer.removeCard(attackCard);
                                currentPlayer.removeCard(defendCard);
                                break;
                            }
                        }
                    }
                }
                updateGame();
            }
        });

        this.defendButton.addActionListener(e -> {
            // Вызываем метод защиты для текущего игрока
            if (this.currentPlayer == game.getAttacker()) {
                JOptionPane.showMessageDialog(null, "Вы должны атаковать");
            } else {
                Card attackCard = game.getLastAttackCard();
                Card defendCard = this.currentPlayer.chooseDefendCard(attackCard, game.getTrumpCard());
                if (defendCard != null && !defendCard.beats(attackCard, game.getTrumpCard())) {
                    JOptionPane.showMessageDialog(null, "Вы выбрали некорректную карту для защиты");
                } else {
                    game.defend(attackCard, defendCard);
                    updateGame();
                }
            }
        });

        // Отображаем главное окно
        this.frame.pack();
        this.frame.setVisible(true);

        // Начинаем игру
        startGame();
    }

    private void startGame() {
        this.currentPlayer = game.getCurrentPlayer();
        updateGame();
    }

    private void updateGame() {
        // Обновляем отображение карт на руках у игроков
        this.playerPanel.removeAll();
        for (Player player : game.getPlayers()) {
            JPanel playerHandPanel = new JPanel();
            playerHandPanel.setBorder(BorderFactory.createTitledBorder(player.getName()));
            for (Card card : player.getHand()) {
                JLabel label = new JLabel(card.toString());
                playerHandPanel.add(label);
            }
            this.playerPanel.add(playerHandPanel);
        }

        // Обновляем отображение текущего игрока
        this.currentPlayerLabel.setText("Ходит: " + this.currentPlayer.getName());

        // Проверяем, есть ли победитель
        if (game.getWinner() != null) {
            JOptionPane.showMessageDialog(null, "Победил игрок " + game.getWinner().getName());
            System.exit(0);
        }

        // Обновляем отображение кнопок и текущего игрока
        this.frame.remove(this.currentPlayerLabel);
        this.currentPlayer = game.getCurrentPlayer();
        this.currentPlayerLabel = new JLabel("Ходит: " + this.currentPlayer.getName());
        this.frame.add(this.currentPlayerLabel, BorderLayout.NORTH);
        if (this.currentPlayer == game.getAttacker()) {
            this.defendButton.setEnabled(false);
            this.attackButton.setEnabled(true);
        } else {
            this.defendButton.setEnabled(true);
            this.attackButton.setEnabled(false);
        }

        // Перерисовываем окно
        this.frame.revalidate();
        this.frame.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DurakGUI::new);
    }
}