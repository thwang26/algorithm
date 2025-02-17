import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] direction = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentRow = Integer.parseInt(st.nextToken());
            int currentCol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int nextRow = Integer.parseInt(st.nextToken());
            int nextCol = Integer.parseInt(st.nextToken());

            int count = find(currentRow, currentCol, nextRow, nextCol, n);
            bw.write(String.valueOf(count));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static int find(int currentRow, int currentCol, int nextRow, int nextCol, int n) {
        Queue<Knight> queue = new LinkedList<>();
        queue.add(new Knight(currentRow, currentCol, 0));
        boolean[][] visited = new boolean[n][n];
        visited[currentRow][currentCol] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            Knight knight = queue.poll();

            if (knight.row == nextRow && knight.col == nextCol) {
                count = knight.count;
            }

            for (int[] each : direction) {
                int nRow = knight.row + each[0];
                int nCol = knight.col + each[1];

                if (isIn(nRow, nCol, n) && !visited[nRow][nCol]) {
                    queue.add(new Knight(nRow, nCol, knight.count + 1));
                    visited[nRow][nCol] = true;
                }
            }
        }

        return count;
    }

    private static boolean isIn(int nRow, int nCol, int n) {
        return nRow >= 0 && nRow < n && nCol >= 0 && nCol < n;
    }

    static class Knight {
        int row;
        int col;
        int count;

        public Knight(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
