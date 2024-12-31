import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<List<Node>> list = new ArrayList();
    static boolean[] visited;
    static int n;
    static int maxNode = 0;
    static int maxCost = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();
            list.get(s).add(new Node(e, w));
            list.get(e).add(new Node(s, w));
        }

        visited = new boolean[n + 1];
        dfs(0, 1);
        Arrays.fill(visited, false);
        dfs(0, maxNode);
        System.out.println(maxCost);
    }

    public static void dfs(int cost, int currentNode) {
        if (cost > maxCost) {
            maxCost = cost;
            maxNode = currentNode;
        }

        visited[currentNode] = true;

        for (Node each : list.get(currentNode)) {
            if (!visited[each.next]) {
                dfs(cost + each.cost, each.next);
            }
        }
    }

    static class Node {
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}
