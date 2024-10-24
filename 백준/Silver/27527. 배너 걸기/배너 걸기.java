import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] A;
    static int[] count = new int[1_000_001];
    static int frequencyCount;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        frequencyCount = getFrequencyCount(m);
        System.out.println(canBanner());
    }

    private static String canBanner() {
        for (int i = 0; i < m; i++) {
            count[A[i]]++;
            if (count[A[i]] == frequencyCount) {
                return "YES";
            }
        }

        for (int i = 1; i < n - m + 1; i++) {
            count[A[i + m - 1]]++;
            count[A[i - 1]]--;
            if (count[A[i + m - 1]] == frequencyCount) {
                return "YES";
            }
        }

        return "NO";
    }

    static int getFrequencyCount(int m) {
        int value = 9 * m / 10;
        if (9 * m % 10 == 0) {
            return value;
        } else {
            return value + 1;
        }
    }
}
