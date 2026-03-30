public class Solution {
    int MOD = 20170805;
    final int NOT = 1;
    final int MOVE = 0;

    public int solution(int m, int n, int[][] cityMap) {
        if (m == n && m == 1) {
            return 1;
        }

        int[][] left = new int[m][n];
        int[][] up = new int[m][n];
        left[0][0] = up[0][0] = 1;

        for (int i = 1; i < n; i++) {
            if (cityMap[0][i] == NOT) {
                break;
            }
            left[0][i] = left[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            if (cityMap[i][0] == NOT) {
                break;
            }
            up[i][0] = up[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == NOT) {
                    continue;
                }

                int leftSum = left[i][j - 1];
                if (cityMap[i][j - 1] == MOVE) {
                    leftSum = (leftSum + up[i][j - 1]) % MOD;
                }

                int upSum = up[i - 1][j];
                if (cityMap[i - 1][j] == MOVE) {
                    upSum = (upSum + left[i - 1][j]) % MOD;
                }

                left[i][j] = leftSum;
                up[i][j] = upSum;
            }
        }

        return (left[m - 1][n - 1] + up[m - 1][n - 1]) % MOD;
    }
}