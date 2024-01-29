import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] wine = new int[n + 1];
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = max(dp[i - 1]);
            dp[i][1] = dp[i - 1][0] + wine[i];
            dp[i][2] = dp[i - 1][1] + wine[i];
        }

        System.out.println(max(dp[n]));
    }

    static int max(int[] arr) {
        int max = 0;
        for (int n : arr) {
            max = Math.max(max, n);
        }

        return max;
    }
}
