import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] map = new long[n + 1][n + 1];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                if (i == j) {
                    continue;
                }
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i == j) {
                        continue;
                    }
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        long min = Integer.MAX_VALUE;
        int number = 0;
        for (int i = 1; i < n + 1; i++) {
            long sum = Arrays.stream(map[i]).sum();
            if (sum < min) {
                min = sum;
                number = i;
            }
        }

        System.out.println(number);
    }
}
