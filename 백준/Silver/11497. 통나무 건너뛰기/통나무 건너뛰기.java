import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(Math.max(findOdd(arr), findEven(arr)));
        }
    }

    private static int findOdd(int[] arr) {
        int max = 0;
        int before = arr[0];
        for (int i = 2; i < arr.length; i += 2) {
            max = Math.max(max, arr[i] - before);
            before = arr[i];
        }
        return max;
    }

    private static int findEven(int[] arr) {
        int max = 0;
        int before = arr[1];
        for (int i = 3; i < arr.length; i += 2) {
            max = Math.max(max, arr[i] - before);
            before = arr[i];
        }
        return max;
    }
}
