import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int maxPassword = Integer.MIN_VALUE;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }

                int start = arr[i][j];
                int end = 0;
                int currentMaxCount = Integer.MIN_VALUE;

                Queue<Node> queue = new LinkedList<>();
                queue.add(new Node(j, i, 0));

                boolean[][] visited = new boolean[n][m];
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    Node current = queue.poll();

                    if (current.count > currentMaxCount) {
                        currentMaxCount = current.count;
                        end = arr[current.y][current.x];
                    }

                    if (current.count == currentMaxCount) {
                        end = Math.max(end, arr[current.y][current.x]);
                    }

                    for (int[] each : direction) {
                        int nx = current.x + each[0];
                        int ny = current.y + each[1];

                        if (isIn(nx, ny, m, n) && !visited[ny][nx] && arr[ny][nx] != 0) {
                            visited[ny][nx] = true;
                            queue.add(new Node(nx, ny, current.count + 1));
                        }
                    }
                }


                if (currentMaxCount > maxCount) {
                    maxCount = currentMaxCount;
                    maxPassword = start + end;
                } else if (currentMaxCount == maxCount) {
                    maxPassword = Math.max(maxPassword, start + end);
                }
            }
        }

        System.out.println(maxPassword);
    }

    static boolean isIn(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
// 가장 긴 최단경로