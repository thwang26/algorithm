import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] arr;
    static int[][] max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        max = new int[n][2];
        iterate(0, n, 1, 0);
        iterate(n - 1, -1, -1, 1);
        int maxLength = 0;
        for (int[] each : max) {
            maxLength = Math.max(maxLength, each[0] + each[1] - 1);
        }

        System.out.println(maxLength);
    }

    private static void iterate(int start, int end, int step, int sort) {
        List<Integer> lis = new ArrayList<>();
        for (int i = start; i != end; i += step) {
            int number = arr[i];
            int idx = Collections.binarySearch(lis, number);

            if (idx >= 0) {
                max[i][sort] = lis.size();
                continue;
            }

            idx = -idx - 1;
            if (idx == lis.size()) {
                lis.add(number);
            } else {
                lis.set(idx, number);
            }

            max[i][sort] = lis.size();
        }
    }
}
