import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            int current = sc.nextInt();
            add(list, current);
        }

        System.out.println(list.size());
    }

    private static void add(List<Integer> list, int current) {
        int idx = Collections.binarySearch(list, current);
        if (idx >= 0) {
            return;
        }

        idx = -idx - 1;
        if (idx == list.size()) {
            list.add(current);
        } else {
            list.set(idx, current);
        }
    }
}