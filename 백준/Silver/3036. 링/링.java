import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int firstGear = sc.nextInt();
        while (n-- > 1) {
            int gear = sc.nextInt();
            int gcd = gcd(firstGear, gear);
            System.out.printf("%d/%d\n", firstGear / gcd, gear / gcd);
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}