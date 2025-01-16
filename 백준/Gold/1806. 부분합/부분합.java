import java.util.Scanner;

public class Main {
    static int n;
    static int s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int min = 100000;
        boolean move;
        do {
            move = false;
            if (right < arr.length) {
                sum += arr[right++];
                move = true;
            }

            if (sum >= s && right - left < min) {
                min = right - left;
            }

            while (sum - arr[left] >= s && left + 1 < right) {
                sum -= arr[left++];
                if (sum >= s && right - left < min) {
                    min = right - left;
                }
                move = true;
            }

        } while (move);

        System.out.println(min == 100000 ? 0 : min);
    }
}
