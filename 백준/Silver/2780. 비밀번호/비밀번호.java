import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        PasswordMaker passwordMaker = new PasswordMaker();
        while (t-- > 0) {
            int n = sc.nextInt();
            passwordMaker.make(n);
            System.out.println(passwordMaker.sum);
            passwordMaker.clear();
        }
    }

    static class PasswordMaker {
        long sum;
        final int MOD_VALUE = 1_234_567;
        long[] count = new long[10];
        List<List<Integer>> graph = List.of(
                List.of(7),
                List.of(2, 4),
                List.of(1, 3, 5),
                List.of(2, 6),
                List.of(1, 5, 7),
                List.of(2, 4, 6, 8),
                List.of(3, 5, 9),
                List.of(4, 8, 0),
                List.of(5, 7, 9),
                List.of(6, 8)
        );

        public void make(int n) {
            init();
            while (--n > 0) {
                next();
            }
            sum = (Arrays.stream(count).sum() % MOD_VALUE);
        }

        private void next() {
            long[] next = new long[10];
            for (int i = 0; i < 10; i++) {
                for (int each : graph.get(i)) {
                    next[each] += count[i];
                    next[each] %= MOD_VALUE;
                }
            }
            count = next;
        }

        private void init() {
            for (int i = 0; i < 10; i++) {
                count[i]++;
            }
        }

        public void clear() {
            this.sum = 0;
            this.count = new long[10];
        }
    }
}