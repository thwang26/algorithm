import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[26];
        sc.next().chars().filter(i -> i != (int) '*').forEach(n -> arr[n - 'A']++);
        sc.next().chars().filter(i -> i != (int) '*').forEach(n -> arr[n - 'A']--);

        System.out.println(Arrays.stream(arr).map(Math::abs).sum() / 2);
    }
}
