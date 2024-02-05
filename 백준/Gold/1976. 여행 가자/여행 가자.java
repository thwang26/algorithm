import java.util.*;

public class Main {
    static List<Connection> connections = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (sc.nextInt() == 1) {
                    connections.add(new Connection(i, j));
                    connections.add(new Connection(j, i));
                }
            }
        }

        arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        connections.sort(Comparator.comparingInt(o -> o.from));
        for (Connection connection : connections) {
            union(connection.from, connection.to);
        }

        for (Connection connection : connections) {
            union(connection.from, connection.to);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(arr[sc.nextInt()]);
        }

//        System.out.println(Arrays.toString(arr));
        System.out.println(set.size() == 1 ? "YES" : "NO");
    }

    private static int find(int a) {
        if (a == arr[a]) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }

    private static void union(int from, int to) {
        int a = find(from);
        int b = find(to);
        if (a != b) {
            arr[a] = b;
        }
    }

    static class Connection {
        int from;
        int to;

        public Connection(int from, int to) {
            this.from = from;
            this.to = to;
        }

    }
}