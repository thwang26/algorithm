import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int maxArea = 0;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[][] arr = new int[n][n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int number = sc.nextInt();
                arr[i][j] = number;
                min = Math.min(min, number);
                max = Math.max(max, number);
            }
        }

        for (int height = 0; height <= max; height++) {
            check(copy(arr), height);
        }

        System.out.println(maxArea);
    }

    static void check(int[][] arr, int height) {
        boolean[][] visited = new boolean[n][n];
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] > height) {
                    visited[i][j] = true;
                    area++;
                    bfs(i, j, arr, visited, height);
                }
            }
        }

        maxArea = Math.max(maxArea, area);
    }

    static void bfs(int i, int j, int[][] arr, boolean[][] visited, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] each : direction) {
                int ny = current[0] + each[0];
                int nx = current[1] + each[1];

                if (isIn(ny, nx, n) && !visited[ny][nx] && arr[ny][nx] > height) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

    static boolean isIn(int y, int x, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static int[][] copy(int[][] arr) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = arr[i][j];
            }
        }

        return copy;
    }
}
