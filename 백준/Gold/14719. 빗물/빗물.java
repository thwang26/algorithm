import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] arr = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < w; i++) {
            int n = arr[i];
            int leftMax = 0;
            int rightMax = 0;

            for (int j = 0; j < i; j++) {
                leftMax = arr[j] > n ? Math.max(leftMax, arr[j]) : leftMax;
            }

            for (int j = i + 1; j < w; j++) {
                rightMax = arr[j] > n ? Math.max(rightMax, arr[j]) : rightMax;
            }

            int min = Math.min(leftMax, rightMax);
            count += min == 0 ? 0 : min - n;
        }

        System.out.println(count);
    }
}
