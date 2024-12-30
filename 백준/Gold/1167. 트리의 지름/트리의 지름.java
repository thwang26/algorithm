import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static List<List<Node>> list = new ArrayList<>();
    static int v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        for (int i = 0; i < v + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            int current = sc.nextInt();
            int next = sc.nextInt();
            while (next != -1) {
                int cost = sc.nextInt();
                list.get(current).add(new Node(next, cost));
                next = sc.nextInt();
            }
        }

        int[] nodes = new int[v + 1];
        Arrays.fill(nodes, Integer.MAX_VALUE);
        findMaxDistance(nodes, 1);
        int maxNode = getMaxDistance(nodes);

        nodes = new int[v + 1];
        Arrays.fill(nodes, Integer.MAX_VALUE);
        findMaxDistance(nodes, maxNode);
        maxNode = getMaxDistance(nodes);

        System.out.println(nodes[maxNode]);
    }

    public static void findMaxDistance(int[] nodes, int currentNode) {
        nodes[currentNode] = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v + 1];
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            for (Node each : list.get(current)) {
                if (!visited[each.next] && nodes[current] + each.cost < nodes[each.next]) {
                    nodes[each.next] = nodes[current] + each.cost;
                    queue.add(each.next);
                }
            }
        }
    }

    public static int getMaxDistance(int[] nodes) {
        int maxNode = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i] == Integer.MAX_VALUE) {
                continue;
            }

            if (max < nodes[i]) {
                max = nodes[i];
                maxNode = i;
            }
        }

        return maxNode;
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
