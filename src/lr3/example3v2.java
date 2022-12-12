package lr3;

import java.util.Scanner;

public class example3v2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество чисел");
        int count = in.nextInt();
        int x = 3;
        int y = 1;
        int z = 1;
        int a;
        System.out.print(y+" "+z+" ");
        while(x <= count){
            a=y+z;
            System.out.print(a+" ");
            y=z;
            z=a;
            x++;
        }
        System.out.println();
    }
}
