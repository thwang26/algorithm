import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int p;
    static int q;
    static int x;
    static int y;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        long answer = getN(n);
        System.out.println(answer);
    }

    private static long getN(Long n) {
        if (n <= 0) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long a = map.containsKey(n / p - x) ? map.get(n / p - x) : getN(n / p - x);
        long b = map.containsKey(n / q - y) ? map.get(n / q - y) : getN(n / q - y);
        map.put(n, a + b);
        return a + b;
    }
}