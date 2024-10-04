import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();
        int p = sc.nextInt();
        int rank = 1;
        while (n-- > 0) {
            int score = sc.nextInt();

            if (t > score || p == 0) {
                break;
            }

            if (t < score) {
                rank++;
            }

            p--;
        }

        System.out.println(p == 0 ? -1 : rank);
    }
}
