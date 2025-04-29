import java.util.*;

class Solution
{
    public int solution(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                // 시작을 i, 끝을 j 로 지정
                if (i > j || s.charAt(i) != s.charAt(j)) {
                    continue;
                } // 시작보다 끝이 작거나, 시작 문자와 끝 문자가 다르면 팰린드롬 판별 x

                if (i == j || i + 1 == j) {
                    dp[i][j] = j - i + 1;
                    continue;
                } // 한칸 or 두칸 팰린드롬

                if (s.charAt(i + 1) == s.charAt(j - 1) && dp[i + 1][j - 1] != 0) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } // 세 칸 이상 팰린드롬
                // 한칸 안쪽만 팰린드롬임이 확실하면 i ~ j도 팰린드롬임
            }
        }

        return Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt();
    }
}