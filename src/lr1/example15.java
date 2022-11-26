package lr1;

import java.util.Scanner;

public class example15 {
    public static void main( String[] args ) {
        int a, b, c, d;
        Scanner sum = new Scanner( System.in );
        System.out.println( "Введите число: ");
        a = sum.nextInt();
        b = sum.nextInt();
        c = a + b;
        d = a - b;
        System.out.println( "Сумма значений: " + c );
        System.out.println( "Разница значений: " + d );
    }

}
// Напишите программу, в которой Пользователь вводит два числа,
// а программой вычисляется и отображается сумма и разность этих чисел.