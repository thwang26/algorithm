import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int totalDegree = 180 * (n - 1);
        while (n-- > 0) {
            totalDegree -= sc.nextInt() * 2;
        }

        System.out.println(totalDegree);
    }
}
