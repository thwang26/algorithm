import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static boolean[][][] visited;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(sc.next().split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[n][m][2];
        bfs();
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 1));
        visited[0][0][1] = true;
        int count = -1;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

//            System.out.println(current.toString());

            if (current.x == m - 1 && current.y == n - 1) {
                count = current.count;
                break;
            }

            for (int[] each : direction) {
                int nx = each[0] + current.x;
                int ny = each[1] + current.y;

                if (isIn(nx, ny, n, m) && !visited[ny][nx][current.bomb] && map[ny][nx] == 0) {
                    visited[ny][nx][current.bomb] = true;
                    queue.add(new Node(nx, ny, current.bomb,
                            current.count + 1));
                }
            } // 일반

            if (current.bomb == 1) {
                for (int[] each : direction) {
                    int nx = each[0] + current.x;
                    int ny = each[1] + current.y;

                    if (isIn(nx, ny, n, m) && !visited[ny][nx][0] && map[ny][nx] == 1) {
                        visited[ny][nx][0] = true;
                        queue.add(new Node(nx, ny, 0,
                                current.count + 1));
                    }
                } // 폭탄
            }
        }

        System.out.println(count);
    }

    private static boolean isIn(int x, int y, int n, int m) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static class Node {
        int x;
        int y;
        int bomb;
        int count;

        public Node(int x, int y, int bomb, int count) {
            this.x = x;
            this.y = y;
            this.bomb = bomb;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", bomb=" + bomb +
                    ", count=" + count +
                    '}';
        }
    }
}
