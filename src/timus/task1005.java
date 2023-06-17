package timus;

import java.util.Scanner;

public class task1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n];

        // Читаем веса камней
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int S = 0;
        for (int w : weights) {
            S += w;
        }

        boolean[][] dp = new boolean[n + 1][S / 2 + 1];
        dp[0][0] = true;

        // Заполняем массив dp
        for (int i = 1; i <= n; i++) {
            int weight = weights[i - 1];
            for (int j = 0; j <= S / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight) {
                    dp[i][j] |= dp[i - 1][j - weight];
                }
            }
        }

        // Находим минимальную разность весов двух куч
        for (int j = S / 2; j >= 0; j--) {
            if (dp[n][j]) {
                System.out.println(S - 2 * j);
                break;
            }
        }
    }
}