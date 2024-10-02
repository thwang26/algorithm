import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int a;
    static int b;
    static int c;

    public static void main(String[] args) {

        while (getTriangle()) {
            if (!canMakeTriangle()) {
                System.out.println("Invalid");
                continue;
            }

            if (a == b && b == c) {
                System.out.println("Equilateral");
            } else if (a == b || b == c || a == c) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }

    public static boolean canMakeTriangle() {
        int[] sides = {a, b, c};
        Arrays.sort(sides);

        return sides[0] + sides[1] > sides[2];
    }

    public static boolean getTriangle() {
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        return a != 0 && b != 0 && c != 0;
    }
}
