package lr1;

import java.util.Scanner;

public class example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя" );
        String name = in.nextLine();
        System.out.println("Введите возраст" );
        int age = in.nextInt();
        System.out.printf("Name: %s Age: %d \n", name, age);
        in.close();
    }
}
// Напишите программу, в которой Пользователь вводит имя и возраст.
// Программа отображает сообщение об имени и возрасте пользователя.
