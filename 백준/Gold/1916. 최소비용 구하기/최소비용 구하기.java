import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int size = n + 1;

        List<List<Node>> list = new ArrayList<>();
        while (size-- > 0) {
            list.add(new ArrayList<>());
        }

        while (m-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            list.get(from).add(new Node(to, cost));
        }

        int from = sc.nextInt();
        int to = sc.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[from] = 0;

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(from, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dp[current.to]) {
                continue;
            }

            for (Node each : list.get(current.to)) {
                if (dp[each.to] > each.cost + current.cost) {
                    dp[each.to] = each.cost + current.cost;
                    pq.add(new Node(each.to, each.cost + current.cost));
                }
            }
        }

        System.out.println(dp[to]);
    }

    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
