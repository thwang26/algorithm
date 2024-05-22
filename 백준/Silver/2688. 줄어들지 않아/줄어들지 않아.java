import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        long[][] arr = getArr();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(Arrays.stream(arr[n]).sum());
        }
    }

    private static long[][] getArr() {
        long[][] arr = new long[65][11];
        for (int i = 1; i <= 10; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i < arr.length; i++) {
            arr[i][1] = Arrays.stream(arr[i - 1]).sum();
            for (int j = 2; j <= 10; j++) {
                arr[i][j] = arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }

        return arr;
    }
}
