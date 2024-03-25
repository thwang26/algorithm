import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();

        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= d; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < d; i++) {
            list.get(i).add(new Node(i, i + 1, 1));
        }

        for (int i = 0; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            if (to - from >= cost && to <= d) {
                list.get(from).add(new Node(from, to, cost));
            }
        }

        int[] dp = new int[d + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dijkstra(dp, list);
        System.out.println(dp[d]);
    }

    static void dijkstra(int[] dp, List<List<Node>> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.from == o2.from) {
                return o1.to - o2.to;
            }
            return o1.from - o2.from;
        });

        pq.addAll(list.get(0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (dp[current.to] >= dp[current.from] + current.cost) {
                dp[current.to] = dp[current.from] + current.cost;
                pq.addAll(list.get(current.to));
            }
        }
    }

    static class Node {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}