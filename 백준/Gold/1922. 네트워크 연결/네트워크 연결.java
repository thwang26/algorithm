import java.io.*;
import java.util.*;

public class Main {
    private final Element e;

    private Main() {
        this.e = new Element();
    }

    static class Element {
        int n;
        int m;
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
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        e.n = Integer.parseInt(br.readLine());
        e.m = Integer.parseInt(br.readLine());
        e.arr = new int[e.n + 1];
        for (int i = 0; i < e.arr.length; i++) {
            e.arr[i] = i;
        }
        e.connections = new Connection[e.m];
        StringTokenizer st;
        for (int i = 0; i < e.m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            e.connections[i] = new Connection(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();
    }

    private void logic() {
        Arrays.sort(e.connections, Comparator.comparingInt(o -> o.cost));
        for (Connection connection : e.connections) {
            if (union(connection.from, connection.to)) {
                e.answer += connection.cost;
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
        if (a != b) {
            e.arr[a] = b;
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