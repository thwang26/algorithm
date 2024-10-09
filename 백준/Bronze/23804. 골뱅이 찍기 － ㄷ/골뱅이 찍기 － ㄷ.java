import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        topDown(n);
        middle(n);
        topDown(n);
    }

    public static void topDown(int n) {
        System.out.print(("@".repeat(5).repeat(n) + "\n").repeat(n));
    }

    public static void middle(int n) {
        System.out.print(("@".repeat(n) + "\n").repeat(3 * n));
    }
}
