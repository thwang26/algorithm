import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n + 2];
        arr[0] = 0;
        arr[arr.length - 1] = l;
        int[] distArr = new int[arr.length - 1];

        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            distArr[i] = arr[i + 1] - arr[i];
        }

        System.out.println(binarySearch(distArr, m));
    }

    private static int binarySearch(int[] dist, int m) {
        int low = 0;
        int high = getMax(dist);
        int mid = 0;

        int minCount = Integer.MAX_VALUE;
        while (low <= high) {
            mid = (low + high) / 2;

            if (mid == 0) {
                low = mid + 1;
                continue;
            }

            int count = 0;
            for (int each : dist) {
                count += each % mid != 0 ? each / mid : each / mid - 1;
            }

            if (count > m) {
                low = mid + 1;
            } else {
                minCount = Math.min(minCount, mid);
                high = mid - 1;
            }
        }

        return minCount;
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int each : arr) {
            max = Math.max(max, each);
        }

        return max;
    }
}
