import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[d + 1][3];

        arr[1][1] = 1;
        arr[2][2] = 1;
        for (int i = 3; i < arr.length; i++) {
            arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
            arr[i][2] = arr[i - 1][2] + arr[i - 2][2];
        }

        getValue(arr[d], k);
    }

    private static void getValue(int[] arr, int k) {
        for (int a = 1; a <= k; a++) {
            int kMinusA = k - (arr[1] * a);
            int b = kMinusA / arr[2];
            if (b * arr[2] == kMinusA) {
                System.out.println(a);
                System.out.println(b);
                return;
            }
        }
    }
}
