import java.util.Scanner;

public class Main {
    static long c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        c = sc.nextLong();

        System.out.println(pow(a, b));
    }

    static long pow(long a, long b) {
        if (b == 1) {
            return a % c;
        }

        long half = pow(a, b/2);

        if (b % 2 == 1) {
            return (half * half % c) * a % c;
        }

        return half * half % c;
    }
}
