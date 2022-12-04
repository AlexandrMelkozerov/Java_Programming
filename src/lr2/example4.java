package lr2;

import java.util.Scanner;

public class example4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int a = in.nextInt();
        if ( a >= 5) if (a <= 10)
            System.out.println("Число " + a + " в диапазоне от 5 до 10 ");

        else
            System.out.println("Число " + a + " не в диапазоне от 5 до 10 ");
    }
}
