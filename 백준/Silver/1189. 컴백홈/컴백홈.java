import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char[][] arr;
    static boolean[][] visited;
    static int r;
    static int c;
    static int k;
    static int way;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new char[r][];
        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        visited = new boolean[r][c];
        visited[r - 1][0] = true;
        dfs(1, r - 1, 0);

        System.out.println(way);
    }

    private static void dfs(int count, int row, int col) {
        if (count >= k && !arrive(row, col)) {
            return;
        }

        if (count == k && arrive(row, col)) {
            way++;
            return;
        }

        for (int[] dir : direction) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if (isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] != 'T') {
                visited[nr][nc] = true;
                dfs(count + 1, nr, nc);
                visited[nr][nc] = false;
            }
        }
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nr < r && nc >= 0 && nc < c;
    }

    private static boolean arrive(int row, int col) {
        return row == 0 && col == c - 1;
    }
}
