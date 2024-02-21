import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
                dp[i][j] %= 1_000_000_000;
            }
        }

        long sum = 0;
        for (int each : dp[n]) {
            sum += each;
        }
        
        System.out.println(sum % 1_000_000_000);
    }
}
