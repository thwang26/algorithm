import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(sc.nextInt());
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                set.add(list.get(i) + list.get(j));
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int current = list.get(i) - list.get(j);
                if (set.contains(current)) {
                    max = Math.max(max, list.get(i));
                }
            }
        }

        System.out.println(max);
    }
}