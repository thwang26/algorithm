import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());
            int[][] arr = new int[row][col];
            while (cabbage-- > 0) {
                st = new StringTokenizer(br.readLine());
                int currentRow = Integer.parseInt(st.nextToken());
                int currentCol = Integer.parseInt(st.nextToken());
                arr[currentRow][currentCol] = 1;
            }

            boolean[][] visited = new boolean[row][col];
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        visited[i][j] = true;
                        count++;
                        find(visited, arr, i, j);
                    }
                }
            }
            bw.write(String.valueOf(count));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void find(boolean[][] visited, int[][] arr, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] each : direction) {
                int nRow = each[0] + current[0];
                int nCol = each[1] + current[1];
                if (isIn(arr.length, arr[0].length, nRow, nCol) && !visited[nRow][nCol] && arr[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
    }

    private static boolean isIn(int row, int col, int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
