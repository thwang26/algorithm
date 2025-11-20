import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        boolean[] eratosthenes = new boolean[MAX + 1];
        Arrays.fill(eratosthenes, true);
        eratosthenes[0] = false;
        eratosthenes[1] = false;
        for (int i = 2; i * i <= MAX; i++) {
            if (!eratosthenes[i]) {
                continue;
            }
            for (int j = i * i; j <= MAX; j += i) {
                eratosthenes[j] = false;
            }
        }

        Set<Long> almostPrime = new HashSet<>();
        for (int i = 2; i <= (int) Math.sqrt(b); i++) {
            if (!eratosthenes[i]) {
                continue;
            }
            for (long j = (long) i * i; j <= b; j *= i) {
                if (j >= a) {
                    almostPrime.add(j);
                }
                if (j > b / i) {
                    break;
                }
            }
        }

        System.out.println(almostPrime.size());
    }
}