package lr1;

import java.util.Scanner;

public class example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("input day" );
        String day  = in.nextLine();

        System.out.println("input date" );
        int date = in.nextInt();

        System.out.println("input month" );
        int month = in.nextInt();

        System.out.println("day: " + day);
        System.out.println("date: " + date);
        System.out.println("month: " + month);
        in.close();
    }
}
