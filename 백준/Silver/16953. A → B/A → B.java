import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = 0;
        while (a < b) {
            if (b % 10 == 1) {
                b /= 10;
                count++;
            } else if (b % 2 == 0) {
                b /= 2;
                count++;
            } else {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(a == b ? count + 1 : -1);
    }
}
