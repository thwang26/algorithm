
public class Solution {
    public int solution(int[] sticker) {
        if (sticker.length == 1) {
            return sticker[0];
        }
        
        int[] dp = new int[sticker.length];
        dp[0] = sticker[0];
        for (int i = 1; i < sticker.length - 1; i++) {
            if (i > 1) {
                dp[i] = Math.max(dp[i - 1], sticker[i] + dp[i - 2]);
            } else {
                dp[i] = Math.max(dp[i - 1], sticker[i]);
            }
        }
        int max = dp[dp.length - 2];
        dp = new int[sticker.length];
        for (int i = 1; i < sticker.length; i++) {
            if (i > 1) {
                dp[i] = Math.max(dp[i - 1], sticker[i] + dp[i - 2]);
            } else {
                dp[i] = Math.max(dp[i - 1], sticker[i]);
            }
        }
        max = Math.max(max, dp[dp.length - 1]);
        System.out.println(max);
        return max;
    }
}
