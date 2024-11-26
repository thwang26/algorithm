import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String[][] arr;
    static List<int[]> list = new ArrayList<>();
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                find(i, j);
            }
        }

        System.out.println(list.size());
        list.forEach(e -> System.out.printf("%d %d\n", e[0] + 1, e[1] + 1));
    }

    private static void find(int i, int j) {
        if (arr[i][j].equals("#")) {
            return;
        }

        if (!isIn(i - 1, j) || arr[i - 1][j].equals("#")) {
            if (isIn(i + 2, j) && arr[i + 1][j].equals(".") && arr[i + 2][j].equals(".")) {
                list.add(new int[]{i, j});
                return;
            }
        }

        if (!isIn(i, j - 1) || arr[i][j - 1].equals("#")) {
            if (isIn(i, j + 2) && arr[i][j + 1].equals(".") && arr[i][j + 2].equals(".")) {
                list.add(new int[]{i, j});
            }
        }
    }

    private static boolean isIn(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
