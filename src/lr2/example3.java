package lr2;

import java.util.Scanner;

public class example3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int num = in.nextInt();
        if(num%4 == 0 && num > 9)
            System.out.println("Число делится на 4");
        else
            System.out.println("Число не делится на 4 или число меньше 10");
        in.close();
    }
}
