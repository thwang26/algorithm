import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int flag = n / 2;
        int term = n / 2;
        while (flag > 0) {
            int number = flag;
            while (number <= n) {
                System.out.print(number + " ");
                number += term;
            }
            flag--;
        }
    }
}
