import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] direction = {-1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] minDp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }

        int[][] maxDp = new int[n][3];

        for (int i = 0; i < 3; i++) {
            minDp[0][i] = arr[0][i];
            maxDp[0][i] = arr[0][i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 3; j++) {
                for (int each : direction) {
                    int nx = j + each;
                    int ny = i + 1;
                    if (isIn(nx)) {
                        minDp[ny][nx] = Math.min(minDp[ny][nx],
                                minDp[i][j] + arr[ny][nx]);

                        maxDp[ny][nx] = Math.max(maxDp[ny][nx],
                                        maxDp[i][j] + arr[ny][nx]);
                    }
                }
            }
        }

        System.out.print(Arrays.stream(maxDp[n - 1]).max().getAsInt());
        System.out.print(" ");
        System.out.print(Arrays.stream(minDp[n - 1]).min().getAsInt());
    }

    static boolean isIn(int each) {
        return each >= 0 && each < 3;
    }
}
