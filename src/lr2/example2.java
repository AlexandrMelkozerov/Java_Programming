package lr2;

import java.util.Scanner;

public class example2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа проверит соответствует ли число критериям:при делении на 5 в остатке получается 2, при делении на 7 в остатке получается 1");
        System.out.println("Введите число : ");

        int A = in.nextInt();
        int B = A % 5;
        int C = A % 7;

        if (B == 2 && C == 1) {
            System.out.println("Удовлетворяет всем критериям!");}
        else if (B == 2 && C != 1) {
            System.out.println("Удовлетворяет одному критерию: при делении на 5 в остатке получается 2");}
        else if (C == 1 && B != 2) {
            System.out.println("Удовлетворяет одному критерию: при делении на 7 в остатке получается 1");}
        else System.out.println("Не удовлетворяет ни одному из требований");

        in.close();

    }

}




