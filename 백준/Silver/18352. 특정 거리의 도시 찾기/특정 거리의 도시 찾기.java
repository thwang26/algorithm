import java.util.*;

public class Main {
    static Main main = new Main();
    Element e = new Element();
    static class Element {
        int N;
        int M;
        int K;
        int X;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        boolean[] visited;
    }

    private void input() {
        Scanner scanner = new Scanner(System.in);

        e.N = scanner.nextInt();
        e.M = scanner.nextInt();
        e.K = scanner.nextInt();
        e.X = scanner.nextInt();
        e.visited = new boolean[e.N];

        for (int i = 0; i < e.N; i++) {
            e.list.add(new ArrayList<>());
        }

        for (int i = 0; i < e.M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            e.list.get(a - 1).add(b);
        }
    }

    private void logic() {
        int[] arr = new int[e.N];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[e.X - 1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(e.X);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            e.visited[n - 1] = true;
            List<Integer> list = e.list.get(n - 1);

            for (int each: list) {
                if (e.visited[each - 1]) {
                    continue;
                }

                arr[each - 1] = Math.min(arr[n - 1] + 1, arr[each - 1]);
                queue.add(each);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != e.K) {
                continue;
            }

            e.answer.add(i + 1);
        }

        e.answer.sort(Comparator.comparingInt(value -> value));
    }

    private void output() {
        if (e.answer.isEmpty()) {
            System.out.println(-1);
        }
        for (int n: e.answer) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        main.input();
        main.logic();
        main.output();
    }
}