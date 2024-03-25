import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            Node root = new Node('r');
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.next());
            }

            list.sort(Comparator.reverseOrder());

            boolean exist = false;
            for (String number : list) {
                if (root.add(number)) {
                    exist = true;
                }
            }

            System.out.println(exist ? "NO" : "YES");
        }


    }

    static class Node {
        char value;
        Set<Node> child = new HashSet<>();

        public Node(char value) {
            this.value = value;
        }

        public boolean add(String number) {
            Node node = this;
            boolean exist = true;
            for (char each : number.toCharArray()) {
                Node child = getNode(node, each);
                if (node.child.add(child)) {
                    exist = false;
                }
                node = child;
            }

            return exist;
        }

        private Node getNode(Node node, char value) {
            for (Node each : node.child) {
                if (each.value == value) {
                    return each;
                }
            }

            return new Node(value);
        }
    }
}
