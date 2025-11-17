import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        HashMap<Integer, Boolean> blocked = new HashMap<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            blocked.put(encode(a, b, c, d), true);
            blocked.put(encode(c, d, a, b), true);
        }

        long[][] map = new long[n + 1][m + 1];
        map[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i != 0) {
                    if (!blocked.containsKey(encode(i, j, i - 1, j))) {
                        map[i][j] += map[i - 1][j];
                    }
                }
                if (j != 0) {
                    if (!blocked.containsKey(encode(i, j, i, j - 1))) {
                        map[i][j] += map[i][j - 1];
                    }
                }
            }
        }

        System.out.println(map[n][m]);
    }

    public static int encode(int a, int b, int c, int d) {
        return (a << 21) | (b << 14) | (c << 7) | d;
    }
}