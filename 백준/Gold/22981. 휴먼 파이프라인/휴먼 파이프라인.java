import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long[] arr;
    static long k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        k = sc.nextLong();

        arr = new long[(int) n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        long minTime = Long.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            long div = div(i);
            if (!isModZero(i)) {
                div++;
            }
            minTime = Math.min(minTime, div);
        }

        System.out.println(minTime);
    }

    public static long div(int i) {
        return k / (arr[0] * i + arr[i] * (arr.length - i));
    }

    public static boolean isModZero(int i) {
        return k % (arr[0] * i + arr[i] * (arr.length - i)) == 0;
    }
}
