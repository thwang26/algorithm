import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] health = new int[n];
        int[] delight = new int[n];

        for (int i = 0; i < n; i++) {
            health[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            delight[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][100];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (health[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - health[i - 1]] + delight[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

//        for (int[] each: dp) {
//            for (int num : each) {
//                System.out.print(num + "\t");
//            }
//            System.out.println();
//        }

        System.out.println(dp[n][99]);
    }
}
