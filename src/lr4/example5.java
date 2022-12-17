package lr4;

import java.util.Random;
import java.util.Scanner;

public class example5 {
    public static void main(String[] args) {
        Random random = new Random(200);
        Scanner id = new Scanner(System.in);
        System.out.println("введите количество  столбцов массива: ");
        int a = id.nextInt();
        System.out.println("введите количество строк массива: ");
        int b = id.nextInt();
        int firstArray[][] = new int[a][b];
        for (int i = 0 ; i <a; i++) {
            for (int j = 0 ; j <b; j++) {
                firstArray[i][j] = random.nextInt(200);
                System.out.println("i = "+i+"; j= "+j+"; value= "+firstArray[i][j]);
            }
        }
        System.out.println("------------------------------------------");

        int secondArray[][] = new int[b][a];
        for (int i = 0 ; i <b; i++) {
            for (int j = 0 ; j <a; j++) {
                secondArray[i][j] = firstArray[j][i];
                System.out.println("i = "+i+";j= "+j+";value= "+secondArray[i][j]);
            }
        }
    }
}

