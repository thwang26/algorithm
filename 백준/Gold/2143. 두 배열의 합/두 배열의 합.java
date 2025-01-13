import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        int a = sc.nextInt();
        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            listA.add(sc.nextInt());
        }
        int b = sc.nextInt();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            listB.add(sc.nextInt());
        }

        Map<Integer, Integer> mapA = new HashMap<>();
        comb(listA, mapA);
        Map<Integer, Integer> mapB = new HashMap<>();
        comb(listB, mapB);

        long total = 0;
        for (int keyA : mapA.keySet()) {
            int keyB = t - keyA;
            if (mapB.containsKey(keyB)) {
                total += (long) mapA.get(keyA) * mapB.get(keyB);
            }
        }

        System.out.println(total);
    }

    private static void comb(List<Integer> list, Map<Integer, Integer> map) {
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            for (int j = i; j < list.size(); j++) {
                sum += list.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
    }
}
