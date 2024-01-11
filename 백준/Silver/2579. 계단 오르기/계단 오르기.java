import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][3];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }

        dp[0][0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == Integer.MIN_VALUE) {
                    continue;
                }

                if (i + 2 < dp.length) {
                    dp[i + 2][1] = Math.max(dp[i + 2][1],
                            arr[i + 2] + dp[i][j]);
                }
                if (j != 2 && i + 1 < dp.length) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], 
                            arr[i + 1] + dp[i][j]);
                }
            }
        }

        int max = 0;
        for (int num : dp[n]) {
            max = Math.max(max, num);
        }

        System.out.println(max);
    }
}
