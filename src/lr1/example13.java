package lr1;

import java.util.Scanner;

public class example13 {
    public static void main( String[] args ) {
        int a, b, c ;
        Scanner sum = new Scanner( System.in );
        System.out.println( "Введите число: ");
        a = sum.nextInt();
        b = sum.nextInt();
        c = a + b;
        System.out.println( "Сумма значений: " + c );
    }

}
// Напишите программу для вычисления суммы двух чисел. Оба числа вводятся пользователем.
// Для вычисления суммы используйте оператор +.
