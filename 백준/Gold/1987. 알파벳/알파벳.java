import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char[][] arr;
    static boolean[] visited = new boolean[26];
    static int maxCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new char[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }

        visited[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(maxCount);
    }

    static void dfs(int x, int y, int count) {
        maxCount = Math.max(maxCount, count);

        for (int[] each : direction) {
            int nx = x + each[0];
            int ny = y + each[1];

            if (isIn(nx, ny, arr.length, arr[0].length)
                    && !visited[arr[ny][nx] - 'A']) {
                visited[arr[ny][nx] - 'A'] = true;
                dfs(nx, ny, count + 1);
                visited[arr[ny][nx] - 'A'] = false;
            }
        }
    }

    static boolean isIn(int x, int y, int n, int m) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
