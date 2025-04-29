class Solution
{
    public int solution(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int n = s.length();
        int max = 1;
        for (int start = n - 1; start >= 0; start--) {
            for (int end = start; end < n; end++) {
                if (s.charAt(start) != s.charAt(end)) {
                    continue;
                }

                if (end - start < 2) {
                    dp[start][end] = end - start + 1;
                } else if (dp[start + 1][end - 1] > 0) {
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                }
                
                max = Math.max(max, dp[start][end]);
            }
            
        }

        return max;
    }
}