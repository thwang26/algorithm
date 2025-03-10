import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int str1Idx = str1.length();
        int str2Idx = str2.length();
        StringBuilder sb = new StringBuilder();
        while (str1Idx != 0 && str2Idx != 0) {
            if (dp[str1Idx - 1][str2Idx] == dp[str1Idx][str2Idx]) {
                str1Idx--;
            } else if (dp[str1Idx][str2Idx - 1] == dp[str1Idx][str2Idx]) {
                str2Idx--;
            } else {
                sb.append(str1.charAt(str1Idx - 1));
                str1Idx--;
                str2Idx--;
            }
        }

        int length = dp[str1.length()][str2.length()];
        System.out.println(length);
        System.out.println(sb.reverse());
    }
}