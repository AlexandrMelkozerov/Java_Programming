package lr2;

import java.util.Scanner;

public class example5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int number = in.nextInt();
        System.out.println("Количество тысяч в числе: " + (number/1000)%10);
        in.close();
    }
}
