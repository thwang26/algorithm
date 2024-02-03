import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] cube = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cube[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        for (int[] each : direction) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int x = j + each[0];
                    int y = i + each[1];
                    if (isIn(y, x, n, m)) {
                        int diff = cube[i][j] - cube[y][x];
                        count += Math.max(diff, 0);
                    } else {
                        count += cube[i][j];
                    }
                }
            }
        }

        System.out.println(count + (n * m * 2));
    }

    static boolean isIn(int y, int x, int n, int m) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
