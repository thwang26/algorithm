import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] l = Arrays.stream(sc.next().split(""))
                .mapToInt(Integer::parseInt).toArray();
        int[] r = Arrays.stream(sc.next().split(""))
                .mapToInt(Integer::parseInt).toArray();

        if (l.length != r.length) {
            System.out.println(0);
            return;
        }

        System.out.println(matchEight(l, r));
    }
    private static int matchEight(int[] l, int[] r) {
        int count = 0;
        for (int i = 0; i < l.length; i++) {
            if (l[i] != r[i]) {
                break;
            }

            if (l[i] == 8) {
                count++;
            }
        }

        return count;
    }
}
