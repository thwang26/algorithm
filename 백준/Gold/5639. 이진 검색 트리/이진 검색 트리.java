import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = new Node(sc.nextInt());
        while (sc.hasNext()) {
            root.add(new Node(sc.nextInt()));
        }

        dfs(root);
    }

    static void dfs(Node node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        dfs(node.right);
        System.out.println(node.value);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        void add(Node node) {
            if (this.value < node.value) {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            } else {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            }
        }
    }
}
