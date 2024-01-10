import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();
        }

        Coordinate target = findTarget();
        bfs(target);
        checkNotAccessible();
        for (int[] each : arr) {
            String[] strings = Arrays.stream(each)
                    .mapToObj(String::valueOf).toArray(String[]::new);
            System.out.println(String.join(" ", strings));
        }

    }

    private static Coordinate findTarget() {
        Coordinate coordinate = null;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {
                    coordinate = new Coordinate(j, i, 0);
                }
            }
        }

        return coordinate;
    }

    private static void bfs(Coordinate target) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(target);
        visited[target.y][target.x] = true;
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            if (arr[current.y][current.x] != 0) {
                arr[current.y][current.x] = current.distance;
            }

            for (int[] each : direction) {
                int nx = current.x + each[0];
                int ny = current.y + each[1];
                if (isIn(nx, ny) && !visited[ny][nx] && arr[ny][nx] != 0) {
                    queue.add(new Coordinate(nx, ny, current.distance + 1));
                    visited[ny][nx] = true;
                }
            }

        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < arr[0].length && y >= 0 && y < arr.length;
    }

    public static void checkNotAccessible() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    arr[i][j] = -1;
                }
            }
        }
    }

    static class Coordinate {
        int x;
        int y;
        int distance;

        public Coordinate(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

}
