import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] horseDirection = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1},
            {-2, 1}, {2, -1}, {-2, -1}};
    static int[][] normalDirection = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int[][] arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Queue<Monkey> queue = new LinkedList<>();
        queue.add(new Monkey(0, 0, 0, k));
        boolean[][][] visited = new boolean[h][w][k + 1];
        visited[0][0][0] = true;
        int count = -1;
        while (!queue.isEmpty()) {
            Monkey current = queue.poll();

            if (current.x == w - 1 && current.y == h - 1) {
                count = current.count;
                break;
            }

            if (current.k > 0) {
                for (int[] each : horseDirection) {
                    int nx = current.x + each[0];
                    int ny = current.y + each[1];

                    if (isIn(nx, ny, w, h) && arr[ny][nx] != 1 && !visited[ny][nx][current.k - 1]) {
                        visited[ny][nx][current.k - 1] = true;
                        queue.add(new Monkey(nx, ny, current.count + 1,
                                current.k - 1));
                    }
                }
            }

            for (int[] each : normalDirection) {
                int nx = current.x + each[0];
                int ny = current.y + each[1];

                if (isIn(nx, ny, w, h) && arr[ny][nx] != 1 && !visited[ny][nx][current.k]) {
                    visited[ny][nx][current.k] = true;
                    queue.add(new Monkey(nx, ny, current.count + 1,
                            current.k));
                }
            }
        }

        System.out.println(count);
    }

    static boolean isIn(int x, int y, int w, int h) {
        return x >= 0 && x < w && y >= 0 && y < h;
    }

    static class Monkey {
        int x;
        int y;
        int count;
        int k;

        public Monkey(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }
}
