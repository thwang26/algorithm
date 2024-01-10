import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];
        for (int i = coin.length - 1; i >= 0; i--) {
            coin[i] = sc.nextInt();
        }

        int amount = 0;
        for (int j : coin) {
            if (k == 0) {
                break;
            }

            amount += k / j;
            k %= j;
        }

        System.out.println(amount);
    }
}
