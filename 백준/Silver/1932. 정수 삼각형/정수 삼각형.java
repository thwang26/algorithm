import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int leftMax = j - 1 >= 0 ? triangle[i - 1][j - 1] : 0;
                int rightMax = triangle[i - 1][j];
                triangle[i][j] = Math.max(leftMax, rightMax) + triangle[i][j];
            }
        }

        System.out.println(Arrays.stream(triangle[n - 1]).max().getAsInt());
    }
}
