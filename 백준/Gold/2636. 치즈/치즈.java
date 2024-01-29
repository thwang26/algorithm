import java.util.*;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static List<Integer> cheeseCount = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y = sc.nextInt();
        int x = sc.nextInt();
        int[][] cheese = new int[y][x];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                cheese[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        while (countCheese(cheese) != 0) {
            count++;
            Queue<Air> queue = new LinkedList<>();
            boolean[][] visited = new boolean[y][x];

            queue.add(new Air(0, 0));
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                Air air = queue.poll();

                for (int[] each : direction) {
                    int nx = each[0] + air.x;
                    int ny = each[1] + air.y;

                    if (isIn(nx, ny, x, y) && !visited[ny][nx]) {
                        if (cheese[ny][nx] == 0) {
                            visited[ny][nx] = true;
                            queue.add(new Air(nx, ny));
                        } else if (cheese[ny][nx] == 1) {
                            visited[ny][nx] = true;
                            cheese[ny][nx] = 0;
                        }
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(cheeseCount.get(cheeseCount.size() - 2));
    }

    private static int countCheese(int[][] cheese) {
        int count = 0;
        for (int[] each : cheese) {
            for (int n : each) {
                if (n == 1) {
                    count++;
                }
            }
        }

        cheeseCount.add(count);
        return count;
    }

    private static boolean isIn(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static class Air {
        int x;
        int y;

        public Air(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
// 공기(0)을 bfs로 순회하면서 공기를 만나면 큐에 넣고 치즈를 만나면 0으로 바꿈
// 둘 다 방문처리
// 순회를 돌기전에 치즈의 개수를 카운트해 0개가 아니라면 순회
// 카운트한 치즈는 list에 기록하여 치즈가 0이 된다면 한 시간 전의 치즈개수를 출력