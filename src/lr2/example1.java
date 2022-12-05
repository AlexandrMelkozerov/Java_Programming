package lr2;

import java.util.Scanner;

public class example1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("input number");
        int n = in.nextInt();
        System.out.println("The number " + (n % 3 !=0 ? "is not " : "") + "divisible by 3");
        in.close();

    }

}
