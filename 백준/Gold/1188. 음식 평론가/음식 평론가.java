import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int lcm = lcm(a, b);
        int lcmModA = lcm / a;
        int lcmModB = lcm / b;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= lcm; i += lcmModB) {
            list.add(i);
        }

        for (int i = 0; i <= lcm; i += lcmModA) {
            list.remove((Integer) i);
        }

        System.out.println(list.size());
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}