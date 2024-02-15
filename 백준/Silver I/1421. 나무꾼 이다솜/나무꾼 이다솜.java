import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int w = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        int max = 0;
        while (n-- > 0) {
            int current = sc.nextInt();
            list.add(current);
            max = Math.max(max, current);
        }

        long cost = 0;
        for (int i = 1; i <= max; i++) {
            long currentCost = 0;
            for (int each : list) {
                if (i > each) {
                    continue;
                }
                int divide = each % i == 0 ? each / i - 1 : each / i;
                int per = each / i;
                long eachCost = (long) per * i * w - (long) divide * c;
                currentCost += eachCost > 0 ? eachCost : 0;
            }
            cost = Math.max(cost, currentCost);
        }

        System.out.println(cost);
    }
}