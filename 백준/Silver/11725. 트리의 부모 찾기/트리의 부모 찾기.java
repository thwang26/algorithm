import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(scan.nextLine());
        boolean[] visited = new boolean[n];
        int[] parents = new int[n];

        for (int i = 1; i < n; i++) {
            String str = scan.nextLine();
            int[] arr = Arrays.stream(str.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            ArrayList<Integer> list;
            if (map.containsKey(arr[0])) {
                list = map.get(arr[0]);
            } else {
                list = new ArrayList<>();
            }
            list.add(arr[1]);
            map.put(arr[0], list);
            if (map.containsKey(arr[1])) {
                list = map.get(arr[1]);
            } else {
                list = new ArrayList<>();
            }
            list.add(arr[0]);
            map.put(arr[1], list);
        }
        queue.add(1);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            ArrayList<Integer> list = map.get(node);
            if (node != 1) {
                for (int num : list) {
                    if (visited[num - 1]) {
                        parents[node - 1] = num;
                    }
                }
            }
            visited[node-1] = true;
            for (int num: list) {
                if (!visited[num-1]) {
                    queue.add(num);
                }
            }
        }
        for (int i = 1; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }
}