import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int weight = Integer.parseInt(br.readLine());
            list.add(new Node(0, i, weight));
        }

        for (int i = 1; i <= n; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    continue;
                }
                int weight = Integer.parseInt(arr[j - 1]);
                list.add(new Node(i, j, weight));
            }
        }

        parent = new int[n + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        list.sort(Comparator.comparingInt(o -> o.weight));
        int minWeight = 0;
        for (Node each : list) {
            if (union(each.from, each.to)) {
                minWeight += each.weight;
            }
        }

        System.out.println(minWeight);
    }

    private static int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    private static boolean union(int from, int to) {
        int a = find(from);
        int b = find(to);

        if (a != b) {
            if (a < b) {
                parent[a] = b;
            } else {
                parent[b] = a;
            }
            return true;
        } else {
            return false;
        }
    }

    static class Node {
        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
