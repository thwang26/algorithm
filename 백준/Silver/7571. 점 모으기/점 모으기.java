import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] row = new int[m];
        int[] col = new int[m];
        for (int i = 0; i < m; i++) {
            row[i] = sc.nextInt();
            col[i] = sc.nextInt();
        }

        Arrays.sort(row);
        Arrays.sort(col);

        int rowMid = row[row.length / 2];
        int colMid = col[col.length / 2];

        int minPoint = IntStream.range(0, m)
                .map(i -> Math.abs(row[i] - rowMid) + Math.abs(col[i] - colMid))
                .sum();

        System.out.println(minPoint);
    }
}
