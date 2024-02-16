import java.util.*;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static int[][] arr;
    static List<Integer> houseAmount = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n][];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(sc.next().split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    find(i, j);
                }
            }
        }

        System.out.println(houseAmount.size());
        houseAmount.sort(Comparator.comparingInt(o -> o));
        houseAmount.forEach(System.out::println);
    }

    private static void find(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{i, j});
        int house = 1;
        while (!queue.isEmpty()) {
            int[] each = queue.poll();

            for (int[] eachDirection : direction) {
                int ny = each[0] + eachDirection[0];
                int nx = each[1] + eachDirection[1];

                if (isIn(nx, ny) && !visited[ny][nx] && arr[ny][nx] == 1) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    house++;
                }
            }
        }

        houseAmount.add(house);
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < arr.length && y >= 0 && y < arr.length;
    }
}