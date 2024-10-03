import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10001];
        
        Arrays.fill(arr, 1);
        IntStream.rangeClosed(2, 10000).forEach(i -> arr[i] += arr[i - 2]);
        IntStream.rangeClosed(3, 10000).forEach(i -> arr[i] += arr[i - 3]);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(arr[n]);
        }
    }
}