import java.util.*;

public class Main {
    static int[][][] box;
    static List<Tomato> ripeTomato = new ArrayList<>();
    static int unripeTomato = 0;
    static int[][] direction = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0},
            {0, 0, 1}, {0, 0, -1}};
    static boolean[][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();

        box = new int[n][m][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    box[j][k][i] = sc.nextInt();
                }
            }
        }

        checkTomato();
        if (unripeTomato == 0) {
            System.out.println(0);
            return;
        }

        visited = new boolean[n][m][h];
        Queue<Tomato> queue = new LinkedList<>(ripeTomato);
        for (Tomato each : ripeTomato) {
            visited[each.y][each.x][each.h] = true;
        }
        int day = 0;
        while (!queue.isEmpty()) {
            Tomato current = queue.poll();

            for (int[] each : direction) {
                int nx = current.x + each[0];
                int ny = current.y + each[1];
                int nh = current.h + each[2];

                if (isIn(nx, ny, nh, m, n, h) && !visited[ny][nx][nh] && box[ny][nx][nh] == 0) {
                    visited[ny][nx][nh] = true;
                    queue.add(new Tomato(nx, ny, nh, current.count + 1));
                    unripeTomato--;

                    if (unripeTomato == 0) {
                        day = current.count + 1;
                    }

                    box[ny][nx][nh] = 1;
                }
            }
        }

        System.out.println(unripeTomato == 0 ? day : -1);
    }

    static void checkTomato() {
        for (int i = 0; i < box[0][0].length; i++) {
            for (int j = 0; j < box.length; j++) {
                for (int k = 0; k < box[0].length; k++) {
                    int tomato = box[j][k][i];
                    if (tomato == 1) {
                        ripeTomato.add(new Tomato(k, j, i, 0));
                    }
                    if (tomato == 0) {
                        unripeTomato++;
                    }
                }
            }
        }
    }

    static boolean isIn(int nx, int ny, int nh, int m, int n, int h) {
        return nx >= 0 && nx < m && ny >= 0 && ny < n && nh >= 0 && nh < h;
    }

    static class Tomato {
        int x;
        int y;
        int h;
        int count;

        public Tomato(int x, int y, int h, int count) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.count = count;
        }
    }
}