import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            for (int j = 1; j <= current; j++) {
                if (i + j >= arr.length) {
                    break;
                }

                if (dp[i] == Integer.MAX_VALUE) {
                    continue;
                }
                
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        System.out.println(dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1]);
    }
}
