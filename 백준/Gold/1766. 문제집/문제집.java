import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            graph.get(first).add(second);
            arr[second]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int current = pq.poll();
            sb.append(current).append(" ");

            for (int next : graph.get(current)) {
                arr[next]--;
                if (arr[next] == 0) {
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}