package lr4;

import java.util.Scanner;

public class example3 {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);// Создание объекта класса Scanner
        System.out.print("введите ширину прямоугольника: "); // пользоватьелю
        int width = id.nextInt(); // число строк которое необходимо вывести
        System.out.print("введите высоту прямоугольника: ");// пользоватьелю
        int height = id.nextInt(); // число строк которое необходимо вывести
        int [][] graph = new int [height][width]; //создание элемента массива необходимого размера
        int z = 0; //переменная для вывода количества строк
        for (int i =0; i < height; i++){//заполнение массива
            for (int j = 0; j <width; j++){
                graph[i][j] = 2;
            }
        }
        for (int i =0; i < height; i++){//печать массива
            int count = i+1;//переменная для повышения номера индекса для вывода на консоль
            System.out.print("номер строки " + count + " : ");
            for (int j = 0; j <width; j++){
                System.out.print(graph[i][j]+" ");
                z++;
            }
            System.out.println(" Количество символов в строке " + z);
            z = 0; //обнуление счетчика
        }
    }
}

