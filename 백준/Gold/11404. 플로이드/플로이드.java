import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[][] map = new long[n + 1][n + 1];
        for (long[] each : map) {
            Arrays.fill(each, Integer.MAX_VALUE);
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == j) {
                    map[i][j] = 0;
                }
            }
        }

        int m = sc.nextInt();
        while (m-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            map[from][to] = Math.min(map[from][to], cost);
        }

        for (int k = 1; k < map.length; k++) {
            for (int i = 1; i < map.length; i++) {
                for (int j = 1; j < map.length; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                if (map[i][j] == Integer.MAX_VALUE) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
