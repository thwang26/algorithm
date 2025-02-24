import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] direction = {
            {1, 1}, {1, 0}, {0, 1}, {-1, 1},
            {-1, 0}, {-1, -1}, {0, -1}, {1, -1}
    };
    static int n;
    static int m;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int current = arr[i][j];
                if (current == 0) {
                    find(i, j);
                }
            }
        }

        System.out.println(max);
    }

    private static void find(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j, 0));
        boolean[][] visited = new boolean[n][m];
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (arr[current.row][current.col] == 1) {
                max = Math.max(max, current.count);
                break;
            }

            for (int[] each : direction) {
                int row = current.row + each[0];
                int col = current.col + each[1];
                if (isIn(row, col) && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new Node(row, col, current.count + 1));
                }
            }
        }
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    static class Node {
        int row;
        int col;
        int count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
