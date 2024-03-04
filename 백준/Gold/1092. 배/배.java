import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> crane = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            crane.add(sc.nextInt());
        }

        int m = sc.nextInt();
        List<Integer> box = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            box.add(sc.nextInt());
        }

        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if (crane.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int minBox = box.get(box.size() - 1);
        crane = crane.stream().filter(c -> c >= minBox)
                .collect(Collectors.toList());

        int ans = 0;
        while (!box.isEmpty()) {
            int boxIdx = 0;
            int craneIdx = 0;
            while (boxIdx < box.size() && craneIdx < crane.size()) {
                if (crane.get(craneIdx) >= box.get(boxIdx)) {
                    box.remove(boxIdx);
                    craneIdx++;
                } else {
                    boxIdx++;
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
}
