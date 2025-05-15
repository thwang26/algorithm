import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Long, int[][]> map;
    static int n;
    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        map = new HashMap<>();
        map.put(1L, mod(matrix));

        int[][] powMatrix = pow(b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(powMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[][] pow(long b) {
        if (map.containsKey(b)) {
            return map.get(b);
        }

        long a = b / 2;
        long c = b - a;
        int[][] mul = mulMatrix(pow(a), pow(c));
        map.put(b, mul);
        return mul;
    }

    private static int[][] mulMatrix(int[][] a, int[][] c) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[i][j] = (matrix[i][j] + a[i][k] * c[k][j]) % MOD;
                }
            }
        }

        return mod(matrix);
    }

    private static int[][] mod(int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] %= 1000;
            }
        }

        return matrix;
    }
}