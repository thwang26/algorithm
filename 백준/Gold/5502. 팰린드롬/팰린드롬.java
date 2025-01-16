import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();
        String rev = reverse(str);

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (str.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(str.length() - dp[n][n]);
    }

    private static String reverse(String str) {
        char[] rev = new char[str.length()];
        for (int i = 0; i < rev.length; i++) {
            rev[i] = str.charAt(str.length() - 1 - i);
        }
        return String.valueOf(rev);
    }
}
