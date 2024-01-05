import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final Element e;

    private Main() {
        this.e = new Element();
    }

    static class Element {
        int n;
        int m;
        int k;
        Set<Integer> kSet = new HashSet<>();
        int[] arr;
        Connection[] connections;
        int answer;
    }

    static class Connection {
        int from;
        int to;
        int cost;

        public Connection(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Connection{" +
                    "from=" + (char)(from + 'A' - 1) +
                    ", to=" + (char)(to + 'A' - 1) +
                    ", cost=" + cost +
                    '}';
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        e.n = Integer.parseInt(st.nextToken());
        e.m = Integer.parseInt(st.nextToken());
        e.k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < e.k; i++) {
            e.kSet.add(Integer.parseInt(st.nextToken()));
        }
        e.arr = new int[e.n + 1];
        for (int i = 0; i < e.arr.length; i++) {
            e.arr[i] = i;
        }
        e.connections = new Connection[e.m];
        for (int i = 0; i < e.m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            e.connections[i] = new Connection(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        br.close();
    }

    private void logic() {
        Arrays.sort(e.connections, (o1, o2) -> {
            if (o1.cost == o2.cost && o1.from == o2.from) {
                return o1.to - o2.to;
            }
            if (o1.cost == o2.cost) {
                return o1.from - o2.from;
            }
            return o1.cost - o2.cost;
        });
        for (Connection connection : e.connections) {
            if (union(connection.from, connection.to)) {
                e.answer += connection.cost;
//                System.out.println(connection.toString());
            }
        }
    }

    private int find(int a) {
        if (a == e.arr[a]) {
            return a;
        }
        return e.arr[a] = find(e.arr[a]);
    }

    private boolean union(int from, int to) {
        int a = find(from);
        int b = find(to);
        if (a != b && !(e.kSet.contains(a) && e.kSet.contains(b))) {
            e.arr[a] = b;
            if (e.kSet.contains(a) || e.kSet.contains(b)) {
                e.kSet.add(a);
                e.kSet.add(b);
            }
            return true;
        }
        return false;
    }

    private void output() {
        System.out.println(e.answer);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.logic();
        main.output();
    }
}