import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int[][] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        if (arr[n - 1][n - 1] == 1) {
            System.out.println(count);
            return;
        }
        arr[n - 1][n - 1] = 2;

        Queue<Pipe> queue = new LinkedList<>();
        queue.add(new Pipe(Status.E, 1, 0));
        while (!queue.isEmpty()) {
            Pipe currentPipe = queue.poll();

            int x = currentPipe.x;
            int y = currentPipe.y;

            if (arr[y][x] == 2) {
                count++;
            }

            for (int[] eachDirection : currentPipe.status.getDirection()) {
                int nx = x + eachDirection[0];
                int ny = y + eachDirection[1];
                Status status = findStatus(eachDirection[0], eachDirection[1]);

                if (isIn(nx, ny) && arr[ny][nx] != 1
                        && diagonalCheck(status, nx, ny)) {
                    queue.add(new Pipe(status, nx, ny));
                }
            }
        }

        System.out.println(count);
    }

    static class Pipe {

        Status status;
        int x;
        int y;
        public Pipe(Status status, int x, int y) {
            this.status = status;
            this.x = x;
            this.y = y;
        }

    }
    enum Status {
        E(new int[][]{{1, 0}, {1, 1}}), // e, se
        S(new int[][]{{0, 1}, {1, 1}}), // s, se
        SE(new int[][]{{1, 0}, {0, 1}, {1, 1}}); // e, s, se

        private final int[][] direction;

        Status(int[][] direction) {
            this.direction = direction;
        }

        public int[][] getDirection() {
            return direction;
        }

    }
    private static Status findStatus(int x, int y) {
        if (x == 0 && y == 1) {
            return Status.S;
        } else if (x == 1 && y == 0) {
            return Status.E;
        } else {
            return Status.SE;
        }
    }

    private static boolean diagonalCheck(Status status, int nx, int ny) {
        if (!status.equals(Status.SE)) {
            return true;
        }
        return arr[ny][nx - 1] != 1 && arr[ny - 1][nx] != 1;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < arr[0].length && y >= 0 && y < arr.length;
    }
}
