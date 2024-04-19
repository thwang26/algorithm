import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Dotori> list;
    static int n;
    static int k;
    static int d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        d = sc.nextInt();

        list = new ArrayList<>();
        while (k-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int term = sc.nextInt();
            list.add(new Dotori(from, to, term));
        }

        binarySearch();
    }

    static void binarySearch() {
        int min = 1;
        int max = n;
        int number = n;
        while (min <= max) {
            int mid = (min + max) / 2;
            int currentD = d;

            for (Dotori each : list) {
                if (each.from > mid) {
                    continue;
                }

                int range = Math.min(mid, each.to) - each.from;
                int terms = range / each.term;

                currentD -= terms + 1;

                if (currentD <= 0) {
                    break;
                }
            }

            if (currentD <= 0) {
                max = mid - 1;
                number = Math.min(number, mid);
            } else {
                min = mid + 1;
            }
        }

        System.out.println(number);
    }

    static class Dotori {
        int from;
        int to;
        int term;

        public Dotori(int from, int to, int term) {
            this.from = from;
            this.to = to;
            this.term = term;
        }
    }
}