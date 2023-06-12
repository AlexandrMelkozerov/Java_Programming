package lr9exam;

import java.util.Scanner;
public class Example3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ввод размера массива
        System.out.print("Введите количество элементов массива: ");
        int n = input.nextInt();

        byte[] array = new byte[n];

        // Ввод элементов массива
        for (int i = 0; i < n; i++) {
            try {
                System.out.print("Введите " + (i + 1) + "-й элемент массива: ");
                array[i] = input.nextByte();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ошибка ввода: введена строка вместо числа");
                return;
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Ошибка ввода: введено число вне диапазона типа byte");
                return;
            }
        }

        // Вычисление суммы элементов массива
        byte sum = 0;
        for (int i = 0; i < n; i++) {
            try {
                sum = (byte) (sum + array[i]);
            } catch (java.lang.ArithmeticException e) {
                System.out.println("Ошибка: вычисление значения за границами диапазона типа");
                return;
            }
        }

        // Вывод результата
        System.out.println("Сумма элементов массива: " + sum);
    }
}