import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        List<Node> tree = new ArrayList<>();
        int n = 0;
        for (int[] each : nodeinfo) {
            tree.add(new Node(++n, each[0], each[1]));
        }

        tree.sort((o1, o2) -> {
            if (o1.y == o2.y) {
                return o1.x - o2.x;
            }
            return o2.y - o1.y;
        });

        Node head = tree.get(0);
        for (int i = 1; i < tree.size(); i++) {
            Node current = tree.get(i);
            add(head, current);
        }

        preOrder(head);
        postOrder(head);
        return new int[][]{toArray(pre), toArray(post)};
    }

    private int[] toArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        pre.add(node.n);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        post.add(node.n);
    }

    private void add(Node head, Node current) {
        if (head.x > current.x) {
            if (head.left != null) {
                add(head.left, current);
            } else {
                head.left = current;
            }
        } else {
            if (head.right != null) {
                add(head.right, current);
            } else {
                head.right = current;
            }
        }
    }

    static class Node {
        int n;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int n, int x, int y) {
            this.n = n;
            this.x = x;
            this.y = y;
        }
    }
}