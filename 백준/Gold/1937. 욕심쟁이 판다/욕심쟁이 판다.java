import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] forest;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        forest = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                forest[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }

//        for (int[] each: dp) {
//            for (int a: each) {
//                System.out.print(a);
//            }
//            System.out.println();
//        }

        System.out.println(max);
    }

    static int dfs(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = 1;

        for (int[] each : direction) {
            int nx = j + each[0];
            int ny = i + each[1];

            if (isIn(ny, nx, forest.length) && forest[i][j] < forest[ny][nx]) {
                dp[i][j] = Math.max(dp[i][j], dfs(ny, nx) + 1);
            }
        }

        return dp[i][j];
    }

    static boolean isIn(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}
