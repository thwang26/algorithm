import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Node>> list = new ArrayList<>();
    static int[] costArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());

        for (int i = 0; i < v + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(next, cost));
        }

        costArr = new int[v + 1];
        Arrays.fill(costArr, Integer.MAX_VALUE);
        costArr[startNode] = 0;

        bfs(startNode);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < costArr.length; i++) {
            if (costArr[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(costArr[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void bfs(int startNode) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startNode, 0));
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.cost > costArr[currentNode.next]) {
                continue;
            }

            for (Node each : list.get(currentNode.next)) {
                if (each.cost + currentNode.cost < costArr[each.next]) {
                    costArr[each.next] = each.cost + currentNode.cost;
                    queue.add(new Node(each.next, costArr[each.next]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
