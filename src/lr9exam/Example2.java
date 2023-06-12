package lr9exam;

import java.util.Scanner;
public class Example2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ввод размеров матрицы
        System.out.print("Введите количество строк: ");
        int rows = input.nextInt();
        System.out.print("Введите количество столбцов: ");
        int columns = input.nextInt();

        int[][] matrix = new int[rows][columns];

        // Заполнение матрицы случайными числами
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }

        // Вывод матрицы
        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Ввод номера столбца
        int columnNumber = 0;
        try {
            System.out.print("Введите номер столбца: ");
            columnNumber = input.nextInt();
            if (columnNumber >= columns) {
                throw new IllegalArgumentException("Столбца с таким номером не существует");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Ошибка ввода: введена строка вместо числа");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Вывод столбца с заданным номером
        System.out.println("Столбец " + columnNumber + ":");
        for (int i = 0; i < rows; i++) {
            System.out.println(matrix[i][columnNumber]);
        }
    }
}