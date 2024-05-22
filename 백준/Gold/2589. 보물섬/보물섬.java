import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int maxShortestPath = Integer.MIN_VALUE;
    static int n;
    static int m;
    static String[][] arr;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j].equals("L")) {
                    find(i, j);
                }
            }
        }

        System.out.println(maxShortestPath);
    }

    private static void find(int i, int j) {
        boolean[][] visited = new boolean[n][m];
        visited[i][j] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            maxShortestPath = Math.max(maxShortestPath, current.count);

            for (int[] each : direction) {
                int ny = current.y + each[0];
                int nx = current.x + each[1];
                if (isIn(ny, nx) && !visited[ny][nx] && arr[ny][nx].equals("L")) {
                    visited[ny][nx] = true;
                    queue.add(new Node(ny, nx, current.count + 1));
                }
            }
        }
    }

    private static boolean isIn(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    static class Node {
        int y;
        int x;
        int count;

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
