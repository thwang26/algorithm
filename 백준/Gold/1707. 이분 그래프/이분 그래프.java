import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int RED = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list;

        int t = sc.nextInt();
        while (t-- > 0) {
            list = new ArrayList<>();
            int v = sc.nextInt();
            int e = sc.nextInt();
            int[] color = new int[v + 1];

            for (int i = 0; i <= v; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                list.get(from).add(to);
                list.get(to).add(from);
            }

            boolean isBinaryGraph = true;
            for (int i = 1; i < color.length; i++) {
                if (color[i] == 0) {
                    isBinaryGraph = bfs(list, color, i);

                    if (!isBinaryGraph) {
                        break;
                    }
                }
            }

            System.out.println(isBinaryGraph ? "YES" : "NO");
        }
    }

    static boolean bfs(List<List<Integer>> list, int[] color, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = RED;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int each : list.get(current)) {
                if (color[each] == 0) {
                    queue.add(each);
                    color[each] = color[current] * -1;
                } else if (color[each] == color[current]) {
                    return false;
                }
            }
        }

        return true;
    }
}
