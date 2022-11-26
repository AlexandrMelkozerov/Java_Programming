package lr1;

import java.util.Scanner;

public class example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите день недели" );
        String day  = in.nextLine();

        System.out.println("Введите дату" );
        int date = in.nextInt();

        System.out.println("Введите номер месяца" );
        int month = in.nextInt();

        System.out.println("day: " + day);
        System.out.println("date: " + date);
        System.out.println("month: " + month);
        in.close();
    }
}
//Напишите программу, в которой Пользователь последовательно вводит название текущего дня недели,
// название месяца и дату (номер дня в месяце). Программа выводит сообщение о сегодняшней дате (день недели, дата, месяц).
