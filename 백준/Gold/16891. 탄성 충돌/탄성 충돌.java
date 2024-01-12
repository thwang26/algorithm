import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m1 = 1;
        int m2 = (int) Math.pow(sc.nextInt(), 2);
        double v1 = 0;
        double v2 = -100;

        int count = 0;
        while (true) {
            double currentV1 = div(m1 - m2, m1 + m2) * v1
                    + div(2 * m2, m1 + m2) * v2;
            double currentV2 = div(2 * m1, m1 + m2) * v1
                    - div(m1 - m2, m1 + m2) * v2;
            count++;
            v1 = currentV1;
            v2 = currentV2;

            if (v1 < 0) {
                count++; // 벽이랑 부딫힘
                v1 = -v1;
            }
            if (v2 - v1 >= 0) {
                break;
            }
        }

        System.out.println(count);
    }

    private static double div(double a, double b) {
        return a / b;
    }
}
