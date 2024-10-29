import java.util.Scanner;

public class Main {
    static final long MOD = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] dp = new long[10001];
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 4; i < dp.length; i += 2) {
            for (int j = 0; j <= i - 2; j += 2) {
                dp[i] += dp[i - 2 - j] * dp[j];
                dp[i] %= MOD;
            }
        }

        System.out.println(dp[n]);
    }
}
