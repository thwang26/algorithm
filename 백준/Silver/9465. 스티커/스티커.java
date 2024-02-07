import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[][] arr = new int[2][n];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int j = 1; j < n; j++) {
                for (int i = 0; i < 2; i++) {
                    arr[i][j] = Math.max(arr[i][j] + arr[i == 0 ? 1 : 0][j - 1],
                            Math.max(arr[0][j - 1], arr[1][j - 1]));
                }
            }

            System.out.println(Math.max(arr[0][n - 1], arr[1][n - 1]));
        }
    }
}
