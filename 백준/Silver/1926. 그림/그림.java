import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int count;
    static int maxArea;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    visited[i][j] = true;
                    findArea(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

    private static void findArea(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        count++;
        int area = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            area++;

            for (int[] each : direction) {
                int ni = current[0] + each[0];
                int nj = current[1] + each[1];
                if (canPaint(ni, nj)) {
                    visited[ni][nj] = true;
                    queue.add(new int[]{ni, nj});
                }
            }
        }

        maxArea = Math.max(maxArea, area);
    }

    private static boolean canPaint(int ni, int nj) {
        return isIn(ni, nj) && !visited[ni][nj] && arr[ni][nj] == 1;
    }

    private static boolean isIn(int ni, int nj) {
        return ni >= 0 && ni < n && nj >= 0 && nj < m;
    }
}
