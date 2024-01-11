import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static String[][] arr;
    static int count;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n][m];
        arr = new String[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().split("");
        }

        Map.Entry<Integer, Integer> coordinate = findI();
        findP(coordinate);
        System.out.println(count == 0 ? "TT" : count);
    }

    static Map.Entry<Integer, Integer> findI() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("I".equals(arr[i][j])) {
                    y = i;
                    x = j;
                }
            }
        }

        return Map.entry(x, y);
    }

    static void findP(Map.Entry<Integer, Integer> coordinate) {
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(coordinate);
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> current = queue.poll();

            int x = current.getKey();
            int y = current.getValue();

            if (arr[y][x].equals("P")) {
                count++;
            }

            for (int[] each : direction) {
                int nx = x + each[0];
                int ny = y + each[1];
                if (isIn(nx, ny) && !visited[ny][nx] &&
                        !arr[ny][nx].equals("X")) {
                    queue.add(Map.entry(nx, ny));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < arr[0].length && y >= 0 && y < arr.length;
    }
}
