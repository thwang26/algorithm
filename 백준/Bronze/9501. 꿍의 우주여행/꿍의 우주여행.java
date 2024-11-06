import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int count = 0;
            while (n-- > 0) {
                int v = sc.nextInt();
                int f = sc.nextInt();
                int c = sc.nextInt();
                if (v * f >= d * c) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
