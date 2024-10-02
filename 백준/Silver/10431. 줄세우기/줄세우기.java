import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                list.add(sc.nextInt());
            }

            int move = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if (list.get(i) < list.get(j)) {
                        int current = list.remove(i);
                        list.add(j, current);
                        move += i - j;
                        break;
                    }
                }
            }

            System.out.printf("%d %d\n", n, move);
        }
    }
}
