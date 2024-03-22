import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int meltCount = 0;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[][] cheese = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cheese[i][j] = sc.nextInt();
            }
        }

        meltCheese(cheese);
        System.out.println(meltCount);
    }

    static void meltCheese(int[][] cheese) {
        if (empty(cheese)) {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] cheeseVisited = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] each : direction) {
                int ny = current[0] + each[0];
                int nx = current[1] + each[1];

                if (isIn(nx, ny, m, n) && !visited[ny][nx]
                        && cheese[ny][nx] == 0) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }

                if (isIn(nx, ny, m, n) && cheese[ny][nx] == 1) {
                    if (cheeseVisited[ny][nx]) {
                        cheese[ny][nx] = 0;
                        visited[ny][nx] = true;
                    } else {
                        cheeseVisited[ny][nx] = true;
                    }
                }
            }
        }

        meltCount++;
        meltCheese(cheese);
    }

    static boolean isIn(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static boolean empty(int[][] cheese) {
        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[0].length; j++) {
                if (cheese[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
