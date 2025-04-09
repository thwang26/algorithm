import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int lan = 0;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                int num = getNumber(chars[j]);
                lan += num;
                if (i == j || num == 0) {
                    continue;
                }
                list.add(new Node(i, j, num));
            }
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        list.sort(Comparator.comparingInt(o -> o.weight));
        int minWeight = 0;
        for (Node each : list) {
            if (union(each.from, each.to)) {
                minWeight += each.weight;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            set.add(find(i));
        }
        System.out.println(set.size() != 1 ? -1 : lan - minWeight);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return false;
        }
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }

        return true;
    }

    private static int getNumber(char c) {
        if (c == '0') {
            return 0;
        }

        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 1;
        }

        return c - 'A' + 27;
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
