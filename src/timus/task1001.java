package timus;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class task1001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Long> deq = new ArrayDeque<>();
        while(sc.hasNext()) {
            long n = sc.nextLong();
            deq.offerFirst(n);
        }
        sc.close();

        while (!deq.isEmpty()) {
            Long num = deq.pollFirst();
            String ns = String.format("%.4f", Math.sqrt(num));
            System.out.println(ns);
        }
    }

}