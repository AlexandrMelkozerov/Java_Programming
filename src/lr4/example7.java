package lr4;

import java.util.Scanner;

public class example7 {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.println("введите количество строк массива: ");
        int a =id.nextInt();
        System.out.println("введите количество столбцов массива: ");
        int b = id.nextInt();
        int Zmeyka[][] = new int[a][b];
        int hvost = 0;
        int telo = 0;
        int h = 0;
        for (int i = 0 ; h <Zmeyka.length ; h++) {
            for (int j = 0 ; j <(Zmeyka[i].length - hvost); j++) {
                Zmeyka[i][j] = telo;
                telo++;
            }
            i++;
            for (int k = i; k <Zmeyka.length; k++) {
                Zmeyka[k][Zmeyka[i].length-1-hvost] = telo;
                telo++;
            }
            hvost++;
        }
        int z = 0;
        for (int i =0; i < Zmeyka.length; i++){
            int count = i+1;
            System.out.print("номер строки " + count + " : ");
            for (int j = 0; j <Zmeyka[i].length; j++){
                System.out.print(Zmeyka[i][j]+" ");
                z++;
            }
            System.out.println(" Количество символов в строке " + z);
            z = 0;
        }

    }
}

