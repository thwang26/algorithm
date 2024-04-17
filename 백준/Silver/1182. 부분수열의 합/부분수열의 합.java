import java.util.Scanner;

public class Main {
    static int count = 0;
    static int s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            part(arr, i, 0, 0, 0);
        }

        System.out.println(count);
    }

    private static void part(int[] arr, int i, int choice, int idx, int sum) {
        if (i == choice && sum == s) {
            count++;
            return;
        }

        if (idx >= arr.length) {
            return;
        }

        part(arr, i, choice + 1, idx + 1, sum + arr[idx]);
        part(arr, i, choice, idx + 1, sum);
    }
}
