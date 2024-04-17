import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            List<Node> building = new ArrayList<>();
            building.add(new Node(0, 0));
            for (int i = 1; i <= n; i++) {
                int cost = sc.nextInt();
                building.add(new Node(i, cost));
            }

            for (int i = 0; i < k; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                building.get(to).from.add(building.get(from));
            }

            int destNode = sc.nextInt();
            bfs(building, destNode);
        }
    }

    private static void bfs(List<Node> building, int destNode) {
        int[] dp = new int[building.size()];
        dp[destNode] = building.get(destNode).cost;
        Queue<Node> queue = new LinkedList<>();
        queue.add(building.get(destNode));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node each : current.from) {
                if (dp[each.n] < dp[current.n] + each.cost) {
                    dp[each.n] = dp[current.n] + each.cost;
                    queue.add(each);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    static class Node {
        int n;
        int cost;
        List<Node> from = new ArrayList<>();

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}
