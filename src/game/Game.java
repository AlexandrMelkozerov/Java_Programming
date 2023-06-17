package game;
import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int secretNumber = rand.nextInt(100) + 1;
        int guess = 0;
        int numGuesses = 0;

        System.out.println("Я загадал число от 1 до 100. Попробуйте его угадать!");

        while (guess != secretNumber) {
            System.out.print("Введите вашу догадку: ");
            guess = input.nextInt();
            numGuesses++;

            if (guess < secretNumber) {
                System.out.println("Мое число больше, чем ваша догадка.");
            } else if (guess > secretNumber) {
                System.out.println("Мое число меньше, чем ваша догадка.");
            } else {
                System.out.println("Поздравляю, вы угадали число!");
                System.out.println("Вам потребовалось " + numGuesses + " попыток.");
            }
        }

        input.close();
    }
}