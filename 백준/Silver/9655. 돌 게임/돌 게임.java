import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        match(n);
    }

    public static void match(int n) {
        System.out.println(n % 2 == 0 ? "CY" : "SK");
    }
}