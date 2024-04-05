import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int maxSafe = 0;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(map, 0);
        System.out.println(maxSafe);
    }

    static void dfs(int[][] map, int wall) {
        if (wall == 3) {
            int[][] copy = copy(map);
            spread(copy);
            int safe = findSafe(copy);
            maxSafe = Math.max(maxSafe, safe);

            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 4;
                    dfs(map, wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int findSafe(int[][] map) {
        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    safe++;
                }
            }
        }

        return safe;
    }

    static int[][] copy(int[][] arr) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = arr[i][j];
            }
        }

        return copy;
    }

    static void spread(int[][] arr) {
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == 2) {
                    visited[i][j] = true;
                    bfs(arr, visited, i, j);
                }
            }
        }
    }

    static void bfs(int[][] arr, boolean[][] visited, int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(j, i));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int[] each : direction) {
                int nx = current.x + each[0];
                int ny = current.y + each[1];

                if (isIn(nx, ny, m, n) && !visited[ny][nx] && arr[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    arr[ny][nx] = 2;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }

    private static boolean isIn(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
