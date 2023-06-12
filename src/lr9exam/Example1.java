package lr9exam;

import java.util.Scanner;
public class Example1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();

            int[] array = new int[size];

            for (int i = 0; i < size; i++) {
                System.out.print("Введите " + (i + 1) + " элемент массива: ");
                array[i] = scanner.nextInt();

                if (array[i] <= 0) {
                    throw new IllegalArgumentException("Элементы массива должны быть положительными числами.");
                }
            }

            double average = calculateAverage(array);
            System.out.println("Среднее значение положительных элементов массива: " + average);

        } catch (java.util.InputMismatchException e) {
            System.err.println("Ошибка ввода данных. Введите целое число.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Массив не содержит положительных элементов.");
        }
    }

    public static double calculateAverage(int[] array) throws ArithmeticException {
        int count = 0;
        int sum = 0;

        for (int element : array) {
            if (element > 0) {
                count++;
                sum += element;
            }
        }

        if (count == 0) {
            throw new ArithmeticException();
        }

        return (double) sum / count;
    }
}