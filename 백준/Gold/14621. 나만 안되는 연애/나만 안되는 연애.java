import java.util.*;

public class Main {
    static int[] arr;
    static String[] gender;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        gender = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            gender[i] = sc.next();
        }

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            if (!gender[from].equals(gender[to])) {
                list.add(new Node(from, to, cost));
            }
        }

        list.sort(Comparator.comparingInt(o -> o.cost));
        int totalCost = 0;
        arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        int nodeCount = 0;
        for (Node node : list) {
            if (union(node.from, node.to)) {
                totalCost += node.cost;
                nodeCount++;
            }

            if (nodeCount == n - 1) {
                break;
            }
        }

        System.out.println(nodeCount == n - 1 ? totalCost : -1);
    }

    private static int find(int a) {
        if (a == arr[a]) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }

    private static boolean union(int from, int to) {
        int a = find(from);
        int b = find(to);
        if (a != b) {
            if (a < b) {
                arr[a] = b;
            } else {
                arr[b] = a;
            }
            return true;
        }
        return false;
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
