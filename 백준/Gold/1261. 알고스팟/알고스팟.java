import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, 1, -1, 0};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] wallBreak = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(wallBreak[i], Integer.MAX_VALUE);
        }

        wallBreak[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == m - 1 && current[1] == n - 1) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if (!isIn(ny, nx)) {
                    continue;
                }

                int isWall = arr[ny][nx] == 1 ? 1 : 0;
                if (wallBreak[current[0]][current[1]] + isWall < wallBreak[ny][nx]) {
                    wallBreak[ny][nx] = wallBreak[current[0]][current[1]] + isWall;
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        System.out.println(wallBreak[m - 1][n - 1]);
    }

    private static boolean isIn(int ny, int nx) {
        return ny >= 0 && ny < m && nx >= 0 && nx < n;
    }
}
