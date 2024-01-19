import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparing(o -> o.current));

        int n = sc.nextInt();
        while (n-- > 0) {
            int m = sc.nextInt();
            String[] arr = new String[m];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.next();
            }

            addNode(pq, arr);
        }

        printNode(pq);
    }

    private static void addNode(PriorityQueue<Node> pq, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Node node = findNode(pq, arr[i]);

            if (node == null) {
                node = new Node(arr[i], i);
                pq.add(node);
            }
            pq = node.chileNode;
        }
    }

    private static void printNode(PriorityQueue<Node> pq) {
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            System.out.println("--".repeat(node.depth) + node.current);
            printNode(node.chileNode);
        }
    }

    private static Node findNode(PriorityQueue<Node> pq, String str) {
        for (Node node : pq) {
            if (node.current.equals(str)) {
                return node;
            }
        }

        return null;
    }

    static class Node {
        String current;
        PriorityQueue<Node> chileNode;
        int depth;

        public Node(String current, int depth) {
            this.current = current;
            this.chileNode = new PriorityQueue<>(Comparator.comparing(o -> o.current));
            this.depth = depth;
        }
    }
}
