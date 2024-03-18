import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ovenDepth = sc.nextInt();
        int totalDough = sc.nextInt();

        List<Integer> oven = new ArrayList<>();
        for (int i = 0; i < ovenDepth; i++) {
            oven.add(sc.nextInt());
        }

        calDepth(oven);

        List<Integer> dough = new ArrayList<>();
        for (int i = 0; i < totalDough; i++) {
            dough.add(sc.nextInt());
        }

        int idx = 0;
        int topIdx = 0;
        for (int i = oven.size() - 1; i >= 0; i--) {
            if (idx >= dough.size()) {
                break;
            }

            int currentOven = oven.get(i);
            int currentDough = dough.get(idx);

            if (currentOven >= currentDough) {
                idx++;
                topIdx = i;
            }
        }

        System.out.println(idx == dough.size() ? topIdx + 1 : 0);
    }

    static void calDepth(List<Integer> oven) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < oven.size(); i++) {
            oven.set(i, Math.min(oven.get(i), min));
            min = oven.get(i);
        }
    }
}
