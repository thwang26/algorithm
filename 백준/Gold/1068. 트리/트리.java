import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeMap.put(i, new Node(i, sc.nextInt()));
        }

        Node root = null;
        for (Map.Entry<Integer, Node> each : nodeMap.entrySet()) {
            if (each.getValue().parent == -1) {
                root = each.getValue();
            } else {
                Node parent = nodeMap.get(each.getValue().parent);
                parent.add(each.getValue());
            }
        }

        Node deleteNode = nodeMap.get(sc.nextInt());
        Node deleteParent = nodeMap.get(deleteNode.parent);

        if (Objects.isNull(deleteParent)) {
            System.out.println(0);
            return;
        }

        deleteParent.child.remove(deleteNode);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int leaf = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.child.isEmpty()) {
                leaf++;
            }

            queue.addAll(current.child);
        }

        System.out.println(leaf);
    }

    static class Node {
        int num;
        int parent;
        List<Node> child;

        public Node(int num, int parent) {
            this.num = num;
            this.parent = parent;
            this.child = new LinkedList<>();
        }

        public void add(Node child) {
            this.child.add(child);
        }
    }
}
