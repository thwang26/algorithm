import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();
        
        if (n >= m) {
            System.out.println(0);
            return;
        }
        
        long answer = 1;
        for (int i = 1; i <= n; i++) {
            answer *= i;
            answer %= m;
        }

        System.out.println(answer);
    }
}
