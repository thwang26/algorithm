import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        long sum = 1;
        boolean bigNumber = false;
        for (int i = 0; i < n; i++) {
            int currentA = a[i];
            for (int j = 0; j < m; j++) {
                int currentB = b[j];

                if (currentA == 1) {
                    break;
                }

                if (currentB == 1) {
                    continue;
                }

                int gcd = gcd(currentA, currentB);
                if (gcd > 1) {
                    sum *= gcd;
                    currentA /= gcd;
                    currentB /= gcd;

                    if (sum >= 1_000_000_000) {
                        sum %= 1_000_000_000;
                        bigNumber = true;
                    }

                    a[i] = currentA;
                    b[j] = currentB;
                }
            }
        }

        if (bigNumber) {
            System.out.printf("%09d", sum);
        } else {
            System.out.println(sum);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
