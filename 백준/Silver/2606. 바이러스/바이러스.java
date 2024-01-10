import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
            list.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            List<Integer> curList = list.get(current);
            for (int each : curList) {
                if (!visited[each]) {
                    visited[each] = true;
                    queue.add(each);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
