import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<List<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(a, b, c));
            list.get(b).add(new Node(b, a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] v1Arr = dijkstra(v1);
        int[] v2Arr = dijkstra(v2);

        int path1 = sumPath(v1Arr[1], v1Arr[v2], v2Arr[n]);
        int path2 = sumPath(v2Arr[1], v2Arr[v1], v1Arr[n]);
        int minPath = Math.min(path1, path2);
        System.out.println(minPath == Integer.MAX_VALUE ? -1 : minPath);
    }

    private static int sumPath(int... path) {
        return Arrays.stream(path)
                .anyMatch(p -> p == Integer.MAX_VALUE)
                ? Integer.MAX_VALUE
                : Arrays.stream(path).sum();
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.addAll(list.get(start));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (dist[current.start] + current.cost < dist[current.end]) {
                dist[current.end] = dist[current.start] + current.cost;
                pq.addAll(list.get(current.end));
            }
        }

        return dist;
    }

    static class Node {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}