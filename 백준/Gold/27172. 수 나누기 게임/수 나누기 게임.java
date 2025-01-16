import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> score = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            arr[i] = value;
            score.put(value, 0);
        }

        for (int each : arr) {
            for (int num = 1; num * num <= each; num++) {
                if (each % num != 0) {
                    continue;
                }

                int div = each / num;

                if (num != each && score.containsKey(num)) {
                    score.put(num, score.get(num) + 1);
                    score.put(each, score.get(each) - 1);
                }

                if (div != each && div != num && score.containsKey(div)) {
                    score.put(div, score.get(div) + 1);
                    score.put(each, score.get(each) - 1);
                }
            }
        }

        for (int each : arr) {
            System.out.print(score.get(each) + " ");
        }
    }
}
