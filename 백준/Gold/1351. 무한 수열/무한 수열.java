import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int p;
    static int q;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        map.put(0L, 1L);

        long answer = map.containsKey(n) ? map.get(n) : getN(n);
        System.out.println(answer);
    }

    private static long getN(Long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long a = map.containsKey(n / p) ? map.get(n / p) : getN(n / p);
        long b = map.containsKey(n / q) ? map.get(n / q) : getN(n / q);
        map.put(n, a + b);
        return a + b;
    }
}