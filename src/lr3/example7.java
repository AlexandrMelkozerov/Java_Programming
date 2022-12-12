package lr3;

import java.util.Scanner;

public class example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = 10;
        char[] arr = new char[size];

        char firstChar = 'a';


        for(int i = 0; i<arr.length; i++) {
            arr[i] = firstChar;
            firstChar+=2;
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        for (int i = arr.length - 1 ; i >= 0; i--){
            System.out.print(arr[i] + " ");
        }
    }
}
