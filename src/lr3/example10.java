package lr3;

import java.util.Arrays;
import java.util.Random;

public class example10 {
    public static void main(String[] args)
    {
        Random random = new Random();
        int num[] = new int[10];
        int reversenum[] = new int[10];

        System.out.print("Изначальный массив: ");
        for (int i = 0; i < 10; i++)
        {
            num[i] = random.nextInt(200);
            System.out.print(num[i] + " ");
        }
        System.out.println();
        Arrays.sort(num);

        System.out.print("Массив в обратном порядке: ");

        for (int i = 0; i < 10; i++)
        {
            reversenum[i]=num[9-i];
            System.out.print(reversenum[i] + " ");
        }
    }
}
