package lr3;

import java.util.Scanner;

public class example3 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите количество чисел ");
            int count = in.nextInt();
            int x = 1;
            int y = 1;
            int z;
            System.out.print(x+" "+y+" ");
            for(int i = 3; i <= count; i++){
                z=x+y;
                System.out.print(z+" ");
                x=y;
                y=z;
            }
            System.out.println();
        }
    }

