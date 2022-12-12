package lr3;

import java.util.Arrays;
import java.util.Scanner;

public class example5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество чисел");
        int value = in.nextInt();
        int[] arr = new int[value];
        int x=0;
        boolean found;

        for(int i = 0; i<arr.length; i++){
            found = true;

            while(found){
                x++;
                if(x%5==2||x%3==1){
                    found=false;

                }
            }
            arr[i] = x;
        }
        System.out.println("Числа попадающие под критерий : " + Arrays.toString(arr));
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        System.out.println("Сумма всех чисел = " + sum);
    }
}
