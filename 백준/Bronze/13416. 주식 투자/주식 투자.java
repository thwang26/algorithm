import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int maxCost = 0;
            int n = sc.nextInt();
            while (n-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                maxCost += Collections.max(List.of(a, b, c, 0));
            }
            System.out.println(maxCost);
        }
    }
}
