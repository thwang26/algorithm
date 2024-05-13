import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int totalBudget = sc.nextInt();
        binarySearch(totalBudget);
    }

    private static void binarySearch(int totalBudget) {
        int left = 0;
        int right = Arrays.stream(arr).max().getAsInt();
        int mid = 0;

        while (left <= right) {
            mid = (right + left) / 2;

            int eachBudget = getEachBudget(mid);

            if (eachBudget > totalBudget) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    private static int getEachBudget(int mid) {
        int budget = 0;
        for (int each : arr) {
            if (mid >= each) {
                budget += each;
            } else {
                budget += mid;
            }
        }

        return budget;
    }
}
