import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1},
            {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            boolean[][] visited = new boolean[h][w];
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        count++;
                        visited[i][j] = true;
                        bfs(visited, map, w, h, i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void bfs(boolean[][] visited, int[][] map, int w, int h, int y,
                    int x) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] each : direction) {
                int ny = current[0] + each[0];
                int nx = current[1] + each[1];

                if (isIn(nx, ny, w, h) && !visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

    private static boolean isIn(int x, int y, int w, int h) {
        return x >= 0 && x < w && y >= 0 && y < h;
    }
}
