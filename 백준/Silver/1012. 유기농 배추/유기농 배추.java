import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            int m = scan.nextInt();
            int n = scan.nextInt();
            int k = scan.nextInt();
            boolean[][] visited = new boolean[n][m];

            while (k-- > 0) {
                int x = scan.nextInt();
                int y = scan.nextInt();

                visited[y][x] = true;
            }

            find(visited);
        }
    }

    public static void find(boolean[][] visited) {
        int answer = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j]) {
                    answer++;
                    worm(j, i, visited, dirs);
                }
            }
        }
        System.out.println(answer);
    }

    public static void worm(int x, int y, boolean[][] visited, int[][] dirs) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[y][x] = false;

        while (!queue.isEmpty()) {
            int[] coo = queue.poll();
            int curX = coo[0];
            int curY = coo[1];

            for (int[] dir : dirs) {
                int nx = curX + dir[0];
                int ny = curY + dir[1];

                if (nx >= 0 && nx < visited[0].length &&
                        ny >= 0 && ny < visited.length && visited[ny][nx]) {
                    queue.add(new int[]{nx, ny});
                    visited[ny][nx] = false;
                }
            }
        }
    }
}
