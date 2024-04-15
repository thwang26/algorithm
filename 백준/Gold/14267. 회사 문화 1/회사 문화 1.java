import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node[] arr = IntStream.range(0, n + 1)
                .mapToObj(i -> new Node(i))
                .toArray(Node[]::new);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                arr[parent].child.add(arr[i]);
                arr[i].parent = arr[parent];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            arr[j].praise += Integer.parseInt(st.nextToken());
        }

        praise(arr[1]);

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i].praise + " ");
        }
    }

    private static void praise(Node node) {
        if (node.num != 1) {
            node.praise += node.parent.praise;
        }

        for (Node child : node.child) {
            praise(child);
        }
    }

    static class Node {
        int num;
        Node parent;
        int praise = 0;
        List<Node> child = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }
    }
}
