import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static long[] fibonacci = new long[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n = 1;
        while (n <= t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            long fibonacci = getFibonacci(p, q);

            bw.write(String.format("Case #%d: %d", n++, fibonacci));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static long getFibonacci(int p, int q) {
        fibonacci[1] = 1 % q;
        for (int i = 2; i <= p; i++) {
            fibonacci[i] = (fibonacci[i - 2] + fibonacci[i - 1]) % q;
        }
        return fibonacci[p];
    }
}
