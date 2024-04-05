import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int maxSafe = 0;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static List<Node> virus = new ArrayList<>();
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int element = sc.nextInt();

                if (element == 2) {
                    virus.add(new Node(j, i));
                }

                map[i][j] = element;
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
                    map[i][j] = 1;
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
        for (Node each : virus) {
            bfs(arr, each);
        }
    }

    static void bfs(int[][] arr, Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int[] each : direction) {
                int nx = current.x + each[0];
                int ny = current.y + each[1];

                if (isIn(nx, ny, m, n) && arr[ny][nx] == 0) {
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
