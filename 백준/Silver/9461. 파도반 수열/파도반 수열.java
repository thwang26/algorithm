import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        long[] dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        for (int i = 5; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
