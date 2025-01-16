import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] palindrome = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < palindrome.length; i++) {
            palindrome[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = dp.length - 1; i >= 1; i--) {
            for (int j = i; j < dp.length; j++) {
                int length = j - i;
                if (length == 0) {
                    dp[i][j] = true;
                    continue;
                }

                if (length <= 2 && palindrome[i] == palindrome[j]) {
                    dp[i][j] = true;
                    continue;
                }

                if (palindrome[i] == palindrome[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}