import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            maze[i] = Arrays.stream(sc.next().split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }

        Queue<Each> queue = new LinkedList<>();
        queue.add(new Each(0, 0, 1));

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Each current = queue.poll();

            if (current.x == m - 1 && current.y == n - 1) {
                System.out.println(current.count);
                break;
            }

            for (int[] each : direction) {
                int ny = current.y + each[0];
                int nx = current.x + each[1];

                if (isIn(nx, ny, m, n) && !visited[ny][nx] && maze[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.add(new Each(ny, nx, current.count + 1));
                }
            }
        }
    }

    static boolean isIn(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static class Each {
        int y;
        int x;
        int count;

        public Each(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
