import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static int x;
    static boolean[][] visited;
    static boolean canVisit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        x = sc.nextInt();

        bfs();

        System.out.println(canVisit ? "ALIVE" : "DEAD");
    }

    private static void bfs() {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0, arr[0][0]));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.y == n - 1 && current.x == m - 1) {
                canVisit = true;
                break;
            }

            for (int i = -x; i <= x; i++) {
                for (int j = -x; j <= x; j++) {
                    int ny = i + current.y;
                    int nx = j + current.x;
                    if (!isIn(ny, nx) || Math.abs(current.x - nx) + Math.abs(current.y - ny) > x
                    || visited[ny][nx] || arr[ny][nx] != current.color) {
                        continue;
                    }

                    visited[ny][nx] = true;
                    queue.add(new Coordinate(ny, nx, current.color));
                }
            }
        }
    }

    private static boolean isIn(int y, int x) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static class Coordinate {
        int y;
        int x;
        int color;

        public Coordinate(int y, int x, int color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }
}
