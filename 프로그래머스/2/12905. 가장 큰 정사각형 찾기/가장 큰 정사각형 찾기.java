class Solution
{
   static int[][] direction = {{-1, 0}, {0, -1}, {-1, -1}};

    public int solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (board[i - 1][j - 1] == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for (int[] each : direction) {
                    min = Math.min(min, dp[i + each[0]][j + each[1]]);
                }
                dp[i][j] = min + 1;
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}