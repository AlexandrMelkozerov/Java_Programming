package lr4;

import java.util.Random;
import java.util.Scanner;

public class example6 {
    public static void main(String[] args) {
        Random random = new Random(200);
        Scanner id = new Scanner(System.in);
        System.out.println("введите количество строк массива: ");
        int a = id.nextInt();
        System.out.println("введите количество столбцов массива: ");
        int b = id.nextInt();
        int firstArray[][] = new int[a][b];
        for (int i = 0 ; i <a; i++) {
            for (int j = 0 ; j <b; j++) {
                firstArray[i][j] = random.nextInt(200);
                System.out.println("i = "+i+";j= "+j+";value= "+firstArray[i][j]);
            }
        }
        System.out.println("------------------------------------------------");

        int deleteS = random.nextInt(a-1);
        int deleteK = random.nextInt(b-1);

        System.out.println("deleteS = "+(deleteS)+";deleteK= "+(deleteK));
        System.out.println("--------------------------------------------------");

        int secondArray[][] = new int[a-1][b-1];
        for (int i=0, s = 0; i<a-1; s++) {
            if (s!=deleteS){
                for (int j =0, k = 0 ; j <b-1; k++) {
                    if (k != deleteK) {
                        secondArray[i][j] = firstArray[s][k];
                        System.out.println("i = " + i + ";j= " + j + ";value= " + secondArray[i][j]);
                        j++;
                    }
                }
                i++;
            }
        }
    }
}

