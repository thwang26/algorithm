import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] arr;
    static int[][] visited;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int[] each : visited) {
            Arrays.fill(each, -1);
        }
        dfs(0, 0);
        System.out.println(visited[0][0]);
    }

    static int dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        if (visited[y][x] == -1) {
            visited[y][x] = 0;

            for (int[] each : direction) {
                int nx = x + each[0];
                int ny = y + each[1];

                if (isIn(nx, ny, m, n) && arr[ny][nx] < arr[y][x]) {
                    visited[y][x] += dfs(nx, ny);
                }
            }
        }

        return visited[y][x];
    }

    private static boolean isIn(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
