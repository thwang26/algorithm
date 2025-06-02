import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static int minDiff = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 1; j < n - 1; j++) {
                for (int d1 = 1; j - d1 >= 0; d1++) {
                    for (int d2 = 1; i + d1 + d2 < n && j + d2 < n; d2++) {
                        count(i, j, d1, d2);
                    }
                }
            }
        }

        System.out.println(minDiff);
    }

    private static void count(int i, int j, int d1, int d2) {
        int[] area = new int[5];
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                area[getAreaNumber(k, l, i, j, d1, d2) - 1] += arr[k][l];
            }
        }

        Arrays.sort(area);
        minDiff = Math.min(minDiff, area[4] - area[0]);
    }

    private static int getAreaNumber(int k, int l, int i, int j, int d1, int d2) {
        if (k < i + d1 && l <= j) {
            int gap = k - i;
            if (k < i || l < j - gap) {
                return 1;
            }
        }
        if (k <= i + d2 && l > j) {
            int gap = k - i;
            if (k < i || l > j + gap) {
                return 2;
            }
        }
        if (k >= i + d1 && l < j + d2 - d1) {
            int gap = i + d1 + d2 - k;
            if (k > i + d1 + d2 || l < j + d2 - d1 - gap) {
                return 3;
            }
        }
        if (k > i + d2 && l >= j + d2 - d1) {
            int gap = i + d1 + d2 - k;
            if (k > i + d1 + d2 || l > j + d2 - d1 + gap) {
                return 4;
            }
        }
        return 5;
    }
}