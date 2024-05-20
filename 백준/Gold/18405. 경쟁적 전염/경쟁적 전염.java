import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static PriorityQueue<Coor> queue = new PriorityQueue<>((o1, o2) -> {
        if (o1.count == o2.count) {
            return o1.value - o2.value;
        }
        return o1.count - o2.count;
    });
    static int[][] arr;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1][n + 1];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] != 0) {
                    queue.add(new Coor(i, j, 0, arr[i][j]));
                }
            }
        }

        int t = sc.nextInt();
        int i = sc.nextInt();
        int j = sc.nextInt();
        bfs(t, i, j);

        System.out.println(arr[i][j]);
    }

    private static void bfs(int t, int i, int j) {
        while (!queue.isEmpty()) {
            Coor current = queue.poll();

            if (current.count == t) {
                continue;
            }

            for (int[] each : direction) {
                int ny = current.y + each[0];
                int nx = current.x + each[1];

                if (isIn(nx, ny) && arr[ny][nx] == 0) {
                    arr[ny][nx] = current.value;
                    queue.add(new Coor(ny, nx, current.count + 1, current.value));
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x > 0 && x <= n && y > 0 && y <= n;
    }

    static class Coor {
        int y;
        int x;
        int count;
        int value;

        public Coor(int y, int x, int count, int value) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.value = value;
        }
    }
}
