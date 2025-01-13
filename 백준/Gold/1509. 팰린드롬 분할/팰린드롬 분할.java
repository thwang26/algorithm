import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        boolean[][] b = new boolean[str.length() + 1][str.length() + 1];
        for (int i = b.length - 1; i >= 1; i--) {
            for (int j = i; j < b.length; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1)) {
                    if (j - i <= 1) {
                        b[i][j] = true;
                    } else if (b[i + 1][j - 1]) {
                        b[i][j] = true;
                    }
                }
            }
        }

        int[] res = new int[str.length() + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 1; i < str.length() + 1; i++) {
            for (int j = i; j < str.length() + 1; j++) {
                if (b[i][j]) {
                    res[j] = Math.min(res[j], res[i - 1] + 1);
                }
            }
        }

        System.out.println(res[res.length - 1]);
    }
}
