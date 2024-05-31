import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] map;
    static int top;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    findTop(i, j);
                }
            }
        }

        System.out.println(top);
    }

    private static void findTop(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        boolean isTop = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int k = -1; k <= 1; k++) {
                for (int l = -1; l <= 1; l++) {
                    if (k == 0 && l == 0) {
                        continue;
                    }

                    int ny = current[0] + k;
                    int nx = current[1] + l;

                    if (isIn(ny, nx)) {
                        if (!visited[ny][nx]) {
                            if (map[ny][nx] == map[current[0]][current[1]]) {
                                visited[ny][nx] = true;
                                queue.add(new int[]{ny, nx});
                            }
                        }

                        if (map[ny][nx] > map[current[0]][current[1]]) {
                            isTop = false;
                        }
                    }
                }
            }
        }

        if (isTop) {
            top++;
        }
    }

    private static boolean isIn(int y, int x) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
