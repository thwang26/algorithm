import java.util.*;

public class Main {
    static int n;
    static int x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Node>> list = new ArrayList<>();
        List<List<Node>> reverseList = new ArrayList<>();

        n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        int m = sc.nextInt();
        x = sc.nextInt();
        while (m-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            list.get(from).add(new Node(from, to, cost));
            reverseList.get(to).add(new Node(to, from, cost));
        }

        int[] xToNode = dijkstra(list);
        int[] nodeToX = dijkstra(reverseList);

        long max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }
            max = Math.max(max, (long) xToNode[i] + nodeToX[i]);
        }

        System.out.println(max);
    }

    public static int[] dijkstra(List<List<Node>> list) {
        Queue<Node> queue = new LinkedList<>(list.get(x));
        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[x] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (arr[current.to] == 0) {
                continue;
            }

            if (arr[current.to] > arr[current.from] + current.cost) {
                arr[current.to] = arr[current.from] + current.cost;
                queue.addAll(list.get(current.to));
            }
        }

        return arr;
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
