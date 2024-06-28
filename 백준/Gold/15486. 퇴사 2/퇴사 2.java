import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int day = sc.nextInt();
            int cost = sc.nextInt();

            if (i + day - 1 <= n) {
                dp[i + day - 1] = Math.max(dp[i + day - 1], cost + dp[i - 1]);
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[n]);
    }
}
