import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Node[] arr = new Node[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = new Node(i, null, new ArrayList<>());
            }

            for (int i = 1; i < n; i++) {
                Node parent = arr[sc.nextInt()];
                Node child = arr[sc.nextInt()];

                parent.child.add(child);
                child.parent = parent;
            }

            int one = sc.nextInt();
            int two = sc.nextInt();

            List<Integer> parentOneList = findParent(arr, one);
            List<Integer> parentTwoList = findParent(arr, two);

            for (int value : parentOneList) {
                if (parentTwoList.contains(value)) {
                    System.out.println(value);
                    break;
                }
            }
        }
    }

    static List<Integer> findParent(Node[] arr, int node) {
        List<Integer> list = new ArrayList<>();
        Node current = arr[node];
        list.add(current.value);
        while (current.parent != null) {
            list.add(current.parent.value);
            current = current.parent;
        }

        return list;
    }

    static class Node {
        int value;
        Node parent;
        List<Node> child;

        public Node(int value, Node parent, List<Node> child) {
            this.value = value;
            this.parent = parent;
            this.child = child;
        }
    }
}