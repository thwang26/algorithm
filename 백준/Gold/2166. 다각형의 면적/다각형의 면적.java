import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[][] arr = new long[n + 1][2];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i][0] = sc.nextLong();
            arr[i][1] = sc.nextLong();
        }

        arr[arr.length - 1][0] = arr[0][0];
        arr[arr.length - 1][1] = arr[0][1];

        long one = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            one += arr[i][0] * arr[i + 1][1];
        }

        long two = 0;
        for (int i = 1; i < arr.length; i++) {
            two += arr[i][0] * arr[i - 1][1];
        }

        System.out.printf("%.1f",
                Math.round(Math.abs(one - two) * 10 / 2d) / 10.0);
    }
}
