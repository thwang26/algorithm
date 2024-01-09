import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) {
                list.add(new Node(b, a));
            } else {
                list.add(new Node(a, b));
            }
        }

        arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (Node node : list) {
            union(node.from, node.to);
        }

        for (Node node : list) {
            union(node.from, node.to);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            set.add(arr[i]);
        }

        System.out.println(set.size());
    }

    private static int find(int a) {
        if (a == arr[a]) {
            return a;
        }
        return arr[a] = find(arr[a]);
    } // 루트 노드를 찾음

    private static boolean union(int from, int to) {
        int a = find(from);
        int b = find(to);
        if (a != b) {
            arr[a] = b;
            return true;
        }
        return false;
    } // 루트 노드가 서로 다르면 연결해줌

    static class Node {
        int from;
        int to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }
    }
}