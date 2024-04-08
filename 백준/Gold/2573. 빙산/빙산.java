import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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

        int time = 0;
        while (true) {
            time++;
            melt();
            int island = checkIsland();

            if (island == 0) {
                System.out.println(0);
                return;
            }

            if (island >= 2) {
                System.out.println(time);
                return;
            }
        }

    }

    static void melt() {
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    visited[i][j] = true;
                    melt(visited, i, j);
                }
            }
        }
    }

    static void melt(boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] each : direction) {
                int ny = current[0] + each[0];
                int nx = current[1] + each[1];

                if (isIn(ny, nx) && !visited[ny][nx]) {
                    if (map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    } else {
                        map[ny][nx]--;
                        if (map[ny][nx] == 0) {
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }
    }

    static int checkIsland() {
        boolean[][] visited = new boolean[n][m];
        int island = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    visited[i][j] = true;
                    island++;
                    bfs(visited, i, j);
                }
            }
        }

        return island;
    }

    static void bfs(boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] each : direction) {
                int ny = current[0] + each[0];
                int nx = current[1] + each[1];

                if (isIn(ny, nx) && !visited[ny][nx] && map[ny][nx] > 0) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

    static boolean isIn(int y, int x) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
