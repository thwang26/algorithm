import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Node> queue = new LinkedList<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        queue.add(new Node(n, 0));
        boolean[] visited = new boolean[100001];
        int minCount = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int num = current.n;
            int count = current.count;

            if (num == k) {
                minCount = Math.min(minCount, count);
            }

            if (num * 2 < visited.length && !visited[num * 2]) {
                queue.add(new Node(num * 2, count + 1));
                visited[num * 2] = true;
            }
            if (num + 1 < visited.length && !visited[num + 1]) {
                queue.add(new Node(num + 1, count + 1));
                visited[num + 1] = true;
            }
            if (num - 1 >= 0 && !visited[num - 1]) {
                queue.add(new Node(num - 1, count + 1));
                visited[num - 1] = true;
            }
        }
        
        System.out.println(minCount);
    }

    static class Node {
        int n;
        int count;

        public Node(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}
