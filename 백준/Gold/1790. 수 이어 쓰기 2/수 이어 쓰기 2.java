import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long count = 9;
        long length = 1;
        long target = 0;

        while (k > count * length) {
            k -= length * count;
            target += count;
            length++;
            count *= 10;
        }

        target = target + 1 + (k - 1) / length;

        if (target > n) {
            System.out.println(-1);
        } else {
            System.out.println(String.valueOf(target).charAt((int) ((k - 1) % length)));
        }
    }
}