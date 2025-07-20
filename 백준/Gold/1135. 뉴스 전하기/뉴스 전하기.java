import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            arr[i] = new Node(i, parent);
            if (parent != -1) {
                arr[parent].child.add(arr[i]);
            }
        }

        System.out.println(getMax(arr[0]));
    }

    private static int getMax(Node node) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (Node child : node.child) {
            int childMax = getMax(child);
            pq.add(childMax);
        }

        int count = 0;
        int value = 0;
        while (!pq.isEmpty()) {
            value = Math.max(value, pq.poll() + count++);
        }

        return node.n == 0 ? value : value + 1;
    }

    static class Node {
        int n;
        int parent;
        List<Node> child = new ArrayList<>();

        public Node(int n, int parent) {
            this.n = n;
            this.parent = parent;
        }
    }
}