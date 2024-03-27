import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int unionDays = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        union(map, l, r);
        System.out.println(unionDays);
    }

    static void union(int[][] map, int l, int r) {
        boolean canUnion = false;
        boolean[][] visited = new boolean[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (makeUnion(map, visited, l, r, i, j)) {
                        canUnion = true;
                    }
                }
            }
        }

        if (canUnion) {
            unionDays++;
            union(map, l, r);
        }
    }

    static boolean makeUnion(int[][] map, boolean[][] visited, int l, int r,
                             int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        List<int[]> unionList = new ArrayList<>();
        unionList.add(new int[]{i, j});

        int sum = map[i][j];
        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] each : direction) {
                int ny = current[0] + each[0];
                int nx = current[1] + each[1];

                if (isIn(map.length, nx, ny) && !visited[ny][nx]
                        && diff(Math.abs(map[current[0]][current[1]] - map[ny][nx]), l, r)) {
                    visited[ny][nx] = true;
                    sum += map[ny][nx];
                    count++;
                    queue.add(new int[]{ny, nx});
                    unionList.add(new int[]{ny, nx});
                }
            }
        }

        if (count == 1) {
            return false;
        } else {
            int avg = sum / count;
            for (int[] each : unionList) {
                map[each[0]][each[1]] = avg;
            }
            return true;
        }
    }

    static boolean diff(int value, int l, int r) {
        return value >= l && value <= r;
    }

    static boolean isIn(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
