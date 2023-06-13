package lr12;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = in.nextInt();

        System.out.println("Введите число: ");
        int numb = in.nextInt();

        int[] arr = new int[size];

        Random random = new Random();

        for(int i=0;i<size;i++){
            arr[i] = random.nextInt();
        }

        System.out.println("Массив arr: ");
        System.out.println(Arrays.toString(arr));

        int[] arrResult = filterEvenNumbers(arr, numb);

        System.out.println("Массив arrResult: ");
        System.out.println(Arrays.toString(arrResult));
    }

    public static int[] filterEvenNumbers(int[] arr, int a){
        return Arrays.stream(arr).filter(x -> x < a).toArray();
    }
}
// Напишите функцию, которая принимает на вход список целых чисел и возвращает новый список,
// содержащий только те числа, которые меньше заданного значения.