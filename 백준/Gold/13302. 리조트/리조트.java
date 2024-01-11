import java.util.Scanner;

public class Main {
    static boolean[] arr;
    static int[][] dp;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new boolean[n + 1];
        if (m != 0) {
            for (int i = 0; i < m; i++) {
                arr[sc.nextInt()] = true;
            }
        }

        dp = new int[n + 1][6];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 6; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(visit(1, 0));
    }

    private static int visit(int day, int coupon) {
        if (day > n) {
            return 0;
        }
        if (arr[day]) {
            return visit(day + 1, coupon);
        }

        if (dp[day][coupon] != -1) {
            return dp[day][coupon];
        }

        dp[day][coupon] = Integer.MAX_VALUE;
        if (coupon >= 3) {
            dp[day][coupon] = Math.min(dp[day][coupon],
                    visit(day + 1, coupon - 3));
        }
        dp[day][coupon] = Math.min(Math.min(dp[day][coupon],
                        visit(day + 1, coupon) + 10000),
                Math.min(visit(day + 3, coupon + 1) + 25000,
                        visit(day + 5, coupon + 2) + 37000));
        return dp[day][coupon];
    }
}
