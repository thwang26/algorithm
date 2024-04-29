import java.util.Scanner;

public class Main {
    static long minTime = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        long min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            min = Math.min(min, arr[i]);
        }

        binarySearch(arr, m, min, min * m);
        System.out.println(minTime);
    }

    private static void binarySearch(int[] arr, int m, long min, long max) {
        long mid;
        while (min <= max) {
            mid = min + (max - min) / 2;

            long people = 0;
//            System.out.println(mid);
            for (int each : arr) {
                people += mid / each;
            }

//            System.out.println(people);
            if (people >= m) {
                max = mid - 1;
                minTime = Math.min(minTime, mid);
            } else {
                min = mid + 1;
            }
        }
    }
}