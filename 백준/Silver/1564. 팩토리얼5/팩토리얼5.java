import java.util.Scanner;

public class Main {
    static long divNumber = 1_000_000_000_000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            sum = getNum(sum);
            sum %= divNumber;
        }

        System.out.printf("%05d", sum % 100000);
    }

    private static long getNum(long i) {
        String str = String.valueOf(i);
        int idx = str.length() - 1;
        while (str.charAt(idx) == '0') {
            idx--;
        }
        return Long.parseLong(str.substring(0, idx + 1));
    }
}
