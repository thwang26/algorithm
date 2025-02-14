import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long maxLength = 0;
    static long[] pa;
    static int n;
    static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        c = sc.nextInt();
        long max = 0;
        pa = new long[n];
        for (int i = 0; i < pa.length; i++) {
            pa[i] = sc.nextInt();
            max = Math.max(max, pa[i]);
        }

        Arrays.sort(pa);
        binarySearch(c, max);
        System.out.println(getRemainPa());
    }

    private static long getRemainPa() {
        long sum = 0;
        for (long each : pa) {
            sum += each;
        }
        return sum - c * maxLength;
    }

    private static void binarySearch(int c, long max) {
        long left = 1;
        long right = max;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            long paCount = getPaCount(mid);
            if (paCount >= c) {
                maxLength = Math.max(maxLength, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    private static long getPaCount(long mid) {
        if (mid == 0) {
            return 0;
        }

        long count = 0;
        for (long each : pa) {
            count += each / mid;
        }
        return count;
    }
}
