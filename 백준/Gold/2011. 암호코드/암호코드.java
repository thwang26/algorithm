import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int DIV = 1_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String code = sc.next();

        if (code.length() == 1) {
            System.out.println(canMake(String.valueOf(code.charAt(0))) ? 1 : 0);
            return;
        }

        int[][] dp = new int[5000][2];
        dp[0][0] = canMake(String.valueOf(code.charAt(0))) ? 1 : 0;
        dp[0][1] = 0;
        dp[1][0] = canMake(String.valueOf(code.charAt(1))) ?
                dp[0][0] + dp[0][1] : 0;
        dp[1][1] = canMake(code.substring(0, 2)) ? 1 : 0;
        for (int i = 2; i < code.length(); i++) {
            if (canMake(String.valueOf(code.charAt(i)))) {
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1] % DIV;
            }

            if (canMake(code.substring(i - 1, i + 1))) {
                dp[i][1] = dp[i - 2][0] + dp[i - 2][1] % DIV;
            } else {
                dp[i][1] = 0;
            }
        }

//        for (int[] each : dp) {
//            System.out.println(each[0] + " " + each[1]);
//        }

        System.out.println(Arrays.stream(dp[code.length() - 1]).sum() % DIV);
    }

    private static boolean canMake(String str) {
        if (str.charAt(0) == '0') {
            return false;
        }

        int num = Integer.parseInt(str);
        return num > 0 && num <= 26;
    }
}
