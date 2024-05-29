import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i] = a - b;
        }

        Arrays.sort(arr);

        if (n % 2 == 1) {
            System.out.println(1);
        } else {
            System.out.println(Math.abs(arr[n / 2] - arr[n / 2 - 1]) + 1);
        }
    }
}
