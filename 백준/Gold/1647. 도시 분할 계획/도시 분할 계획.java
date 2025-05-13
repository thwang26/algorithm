import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Connection> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Connection(start, end, cost));
        }

        int totalCost = 0;
        int maxCost = 0;
        dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        while (!pq.isEmpty()) {
            Connection each = pq.poll();
            if (union(each.start, each.end)) {
                totalCost += each.cost;
                maxCost = Math.max(maxCost, each.cost);
            }
        }

        System.out.println(totalCost - maxCost);
    }

    private static boolean union(int start, int end) {
        int a = find(start);
        int b = find(end);

        if (a == b) {
            return false;
        }

        if (a < b) {
            dp[a] = b;
        } else {
            dp[b] = a;
        }

        return true;
    }

    private static int find(int a) {
        if (a == dp[a]) {
            return a;
        }
        return dp[a] = find(dp[a]);
    }

    static class Connection {
        int start;
        int end;
        int cost;

        public Connection(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
