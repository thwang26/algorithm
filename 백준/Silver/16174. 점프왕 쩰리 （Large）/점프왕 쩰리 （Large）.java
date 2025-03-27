import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    continue;
                }

                if (i == n - 1 && j == n - 1) {
                    System.out.println("HaruHaru");
                    return;
                }
                
                for (int[] each : new int[][]{{0, arr[i][j]}, {arr[i][j], 0}}) {
                    if (isIn(each[0] + i, each[1] + j)) {
                        visited[each[0] + i][each[1] + j] = true;
                    }
                }

                visited[i][j] = false;
            }
        }

        System.out.println("Hing");
    }

    private static boolean isIn(int currentRow, int currentCol) {
        return currentCol >= 0 && currentCol < n && currentRow >= 0 && currentRow < n;
    }
}