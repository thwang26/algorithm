import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int w = sc.nextInt();

            long[][] arr = new long[n + 1][n + 1];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if (i == j) {
                        continue;
                    }
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0; i < m; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost = sc.nextInt();
                arr[from][to] = Math.min(arr[from][to], cost);
                arr[to][from] = Math.min(arr[to][from], cost);
            }

            for (int i = 0; i < w; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost = sc.nextInt();
                arr[from][to] = Math.min(arr[from][to], -cost);
            }

            for (int k = 0; k <= n; k++) {
                for (int i = 0; i <= n; i++) {
                    for (int j = 0; j <= n; j++) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }

            boolean isTimeDecrease = false;
            for (int i = 0; i <= n; i++) {
                if (arr[i][i] < 0) {
                    isTimeDecrease = true;
                    break;
                }
            }

            System.out.println(isTimeDecrease ? "YES" : "NO");
        }
    }
}
