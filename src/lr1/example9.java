package lr1;

import java.util.Scanner;

public class example9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("input day of the month" );

        int month = in.nextInt();
        if (month == 1){
            System.out.println("Январь 31 день");

        }
        if (month == 2){
            System.out.println("Февраль 28 дней");
        }
        if (month == 3){
            System.out.println("Март 31 день");
        }
        if (month == 4){
            System.out.println("Апрель 30 дней");
        }
        if (month == 5){
            System.out.println("Май 31 день");
        }
        if (month == 6){
            System.out.println("Июнь 30 дней");
        }
        if (month == 7){
            System.out.println("Июль 31 день");
        }
        if (month == 8){
            System.out.println("Август 31 день");
        }
        if (month == 9){
            System.out.println("Сентябрь 30 дней");
        }
        if (month == 10){
            System.out.println("Октябрь 31 день");
        }
        if (month == 11){
            System.out.println("Ноябрь 30 дней");
        }
        if (month == 12) {
            System.out.println("Декабрь 31 день");
        }

        in.close();
    }
}
