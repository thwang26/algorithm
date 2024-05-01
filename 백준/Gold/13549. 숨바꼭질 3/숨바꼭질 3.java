import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        Queue<Subin> queue = new LinkedList<>();
        queue.add(new Subin(a, 0));
        int[] visited = new int[100001];
        visited[a] = 0;
        Arrays.fill(visited, Integer.MAX_VALUE);
        int minCount = 100000;
        while (!queue.isEmpty()) {
            Subin current = queue.poll();

            if (current.n == b) {
                minCount = Math.min(minCount, current.count);
                continue;
            }

            for (int each : new int[]{current.n + 1, current.n - 1, current.n * 2}) {
                if (each < 0 || each > 100000) {
                    continue;
                }

                if (visited[each] > current.count) {
                    if (each == current.n * 2) {
                        queue.add(new Subin(each, current.count));
                        visited[each] = current.count;
                    } else {
                        queue.add(new Subin(each, current.count + 1));
                        visited[each] = current.count + 1;
                    }
                }
            }

            if (current.n > b) {
                queue.add(new Subin(b, current.count + current.n - b));
            }
        }

        System.out.println(minCount);
    }

    static class Subin {
        int n;
        int count;

        public Subin(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}
