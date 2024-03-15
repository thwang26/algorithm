import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().split("");
        }

        int normal = findArea(arr);
        redGreen(arr);
        int redGreen = findArea(arr);

        System.out.printf("%d %d", normal, redGreen);
    }

    private static int findArea(String[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (!visited[i][j]) {
                    count++;
                    findArea(arr, visited, i, j);
                }
            }
        }

        return count;
    }

    private static void findArea(String[][] arr, boolean[][] visited
            , int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] each : direction) {
                int ny = each[0] + current[0];
                int nx = each[1] + current[1];

                if (isIn(arr.length, nx, ny) && !visited[ny][nx]
                        && arr[current[0]][current[1]].equals(arr[ny][nx])) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

    private static boolean isIn(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static void redGreen(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j].equals("G")) {
                    arr[i][j] = "R";
                }
            }
        }
    }
}