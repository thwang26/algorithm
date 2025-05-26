import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = 0;
            int b = 0;
            int sum = -1;
            while (Math.max(m * a, n * b) < m * n) {
                int xSum = m * a + x;
                int ySum = n * b + y;
                if (xSum == ySum) {
                    sum = xSum;
                    break;
                }

                if (xSum < ySum) {
                    a++;
                } else {
                    b++;
                }
            }

            System.out.println(sum);
        }
    }
}