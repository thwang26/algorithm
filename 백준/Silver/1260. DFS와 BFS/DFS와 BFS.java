import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] info = new int[3];

        for (int i = 0; i < 3; i++) {
            info[i] = scan.nextInt();
        }

        int[][] tc = new int[info[1]][2];
        for (int i = 0; i < info[1]; i++) {
            tc[i][0] = scan.nextInt();
            tc[i][1] = scan.nextInt();
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : tc) {
            List<Integer> list = map.getOrDefault(arr[0], new ArrayList<>());
            list.add(arr[1]);
            map.put(arr[0], list);
            List<Integer> list2 = map.getOrDefault(arr[1], new ArrayList<>());
            list2.add(arr[0]);
            map.put(arr[1], list2);
        }

        bfs(info, map);
        dfs(info, map);
    }

    public static void bfs(int[] info, Map<Integer, List<Integer>> map) {
        int node = info[0];
        int start = info[2];

        Stack<Map.Entry<Integer, List<Integer>>> stack = new Stack<>();
        boolean[] visited = new boolean[node + 1];

        stack.push(new AbstractMap.SimpleEntry<>(start, map.get(start)));
        while (!stack.isEmpty()) {
            Map.Entry<Integer, List<Integer>> entry = stack.pop();
            int key = entry.getKey();
            List<Integer> value = entry.getValue();

            if (visited[key]) {
                continue;
            }
            System.out.print(key + " ");
            visited[key] = true;

            if (value == null) {
                continue;
            }
            value.sort((o1, o2) -> o2 - o1);
            for (int n : value) {
                if (visited[n]) {
                    continue;
                }
                stack.push(new AbstractMap.SimpleEntry<>(n, map.get(n)));
            }
        }
        System.out.println();
    }

    public static void dfs(int[] info, Map<Integer, List<Integer>> map) {
        int node = info[0];
        int start = info[2];

        Queue<Map.Entry<Integer, List<Integer>>> queue = new LinkedList<>();
        boolean[] visited = new boolean[node + 1];

        queue.add(new AbstractMap.SimpleEntry<>(start, map.get(start)));
        while (!queue.isEmpty()) {
            Map.Entry<Integer, List<Integer>> entry = queue.poll();
            int key = entry.getKey();
            List<Integer> value = entry.getValue();

            if (visited[key]) {
                continue;
            }
            System.out.print(key + " ");
            visited[key] = true;

            if (value == null) {
                continue;
            }
            value.sort(Comparator.comparingInt(o -> o));
            for (int n : value) {
                if (visited[n]) {
                    continue;
                }
                queue.add(new AbstractMap.SimpleEntry<>(n, map.get(n)));
            }
        }
        System.out.println();
    }
}