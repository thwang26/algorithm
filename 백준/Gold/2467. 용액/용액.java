import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = arr.length - 1;
        int minDifferent = Math.abs(arr[left] + arr[right]);
        int[] value = new int[]{arr[left], arr[right]};
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < minDifferent) {
                minDifferent = Math.abs(sum);
                value = new int[]{arr[left], arr[right]};
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(value[0] + " " + value[1]);
    }
}
