import java.util.Scanner;

public class Main {
    static long[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        arr = new long[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) {
                    continue;
                }
                arr[i][j] = Integer.MAX_VALUE;
            }
        }

        while (e-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            arr[from][to] = cost;
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        long answer = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) {
                    continue;
                }

                if (isConnected(i, j)) {
                    answer = Math.min(answer, arr[i][j] + arr[j][i]);
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static boolean isConnected(int i, int j) {
        return arr[i][j] != Integer.MAX_VALUE && arr[j][i] != Integer.MAX_VALUE;
    }
}