import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static Queue<int[]> queue;
    static int r;
    static int c;
    static int airPurifier;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < r; i++) {
            if (map[i][0] == -1) {
                airPurifier = i;
                break;
            }
        }

        while (t-- > 0) {
            spreadDust();
            moveDust(new Direction(1, airPurifier));
            moveDust(new Direction(0, airPurifier + 1));
        }

        System.out.println(getTotalDust());
    }

    private static void print() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int getTotalDust() {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }

    private static void moveDust(Direction d) {
        int beforeDust = 0;
        d.next();
        while (map[d.row][d.col] != -1) {
            int temp = map[d.row][d.col];
            map[d.row][d.col] = beforeDust;
            beforeDust = temp;
            d.next();
        }
    }

    private static boolean isOk(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c;
    }

    private static void spreadDust(int i, int j) {
        int value = map[i][j] / 5;
        for (int[] dir : Direction.direction) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (isOk(row, col) && map[row][col] != -1) {
                queue.add(new int[]{row, col, value});
                map[i][j] -= value;
            }
        }
    }

    private static void spreadDust() {
        queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    spreadDust(i, j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            map[current[0]][current[1]] += current[2];
        }
    }

    static class Direction {
        static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] cw = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int[][] acw = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int idx = 0;
        int[][] current;
        int row;
        int col;

        public Direction(int n, int row) {
            if (n == 1) {
                current = cw;
            } else {
                current = acw;
            }
            this.row = row;
            this.col = 0;
        }

        public void next() {
            if (!isOk(row + current[idx][0], col + current[idx][1])) {
                idx++;
            }
            row += current[idx][0];
            col += current[idx][1];
        }
    }
}
