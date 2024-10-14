import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][][] arr = new int[n + 1][n + 1][11];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                arr[i][j][sc.nextInt()]++;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                for (int k = 1; k < arr[0][0].length; k++) {
                    arr[i][j][k] += arr[i - 1][j][k] + arr[i][j - 1][k] - arr[i - 1][j - 1][k];
                }
            }
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            int row1 = sc.nextInt();
            int col1 = sc.nextInt();
            int row2 = sc.nextInt();
            int col2 = sc.nextInt();

            int query = 0;
            for (int k = 1; k < arr[0][0].length; k++) {
                int square1 = arr[row2][col2][k];
                int square2 = arr[row2][col1 - 1][k];
                int square3 = arr[row1 - 1][col2][k];
                int square4 = arr[row1 - 1][col1 - 1][k];

                if (square1 - square2 - square3 + square4 > 0) {
                    query++;
                }
            }

            System.out.println(query);
        }
    }
}