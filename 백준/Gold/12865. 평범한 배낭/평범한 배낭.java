import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();

            for (int j = arr.length - 1; j >= 0; j--) {
                if (w > j) {
                    continue;
                }
                arr[j] = Math.max(arr[j], arr[j - w] + v);
            }
        }

        System.out.println(arr[k]);
    }
}
