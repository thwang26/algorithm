import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[n][n];
        boolean usePoza = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    if (m > 0) {
                        usePoza = true;
                    }
                    visited[i][j] = true;
                    int currentPoza = find(i, j);
                    int div = currentPoza / k;
                    if (currentPoza % k != 0) {
                        div++;
                    }
                    m -= div;
                }
            }
        }

        if (m < 0 || !usePoza) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("POSSIBLE");
            System.out.println(m);
        }
    }

    private static int find(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int currentPoza = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] each : direction) {
                int row = current[0] + each[0];
                int col = current[1] + each[1];
                if (isIn(row, col) && !visited[row][col] && map[row][col] == 0) {
                    queue.add(new int[]{row, col});
                    visited[row][col] = true;
                    currentPoza++;
                }
            }
        }

        return currentPoza;
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
