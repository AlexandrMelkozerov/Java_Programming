package lr3;

import java.util.Scanner;

public class example4v2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите наименьшее число");
        int min = in.nextInt();
        System.out.println("Введите наибольшее число");
        int max = in.nextInt();
        while(min<=max){
            System.out.print(min+" ");
            min++;
        }
        System.out.println();
    }
}
