import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node[] arr = new Node[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Node((char) ( i + 'A'));
        }

        while (n-- > 0) {
            char root = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);

            if (left != '.') {
                arr[root - 'A'].left = arr[left - 'A'];
            }

            if (right != '.') {
                arr[root - 'A'].right = arr[right - 'A'];
            }
        }

        order("pre", arr[0]);
        System.out.println();
        order("in", arr[0]);
        System.out.println();
        order("post", arr[0]);
    }

    static void order(String query, Node node) {
        if (node == null) {
            return;
        }

        if (query.equals("pre")) {
            System.out.print(node.value);
            order(query, node.left);
            order(query, node.right);
        } else if (query.equals("in")) {
            order(query, node.left);
            System.out.print(node.value);
            order(query, node.right);
        } else if (query.equals("post")) {
            order(query, node.left);
            order(query, node.right);
            System.out.print(node.value);
        }
    }

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }
}
