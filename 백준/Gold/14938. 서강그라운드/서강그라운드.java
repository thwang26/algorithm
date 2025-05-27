import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i == j) {
                    continue;
                }
                dp[i][j] = 10000;
            }
        }

        while (r-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            dp[a][b] = i;
            dp[b][a] = i;
        }


        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int maxItem = 0;
        for (int i = 1; i <= n; i++) {
            int current = items[i];
            for (int j = 1; j <= n; j++) {
                if (i == j || dp[i][j] > m) {
                    continue;
                }
                current += items[j];
            }
            maxItem = Math.max(maxItem, current);
        }

        System.out.println(maxItem);
    }
}
