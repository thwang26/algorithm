import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static long totalValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Jewel> jewelList = new ArrayList<>();
        List<Integer> bagList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            jewelList.add(new Jewel(weight, value));
        }

        for (int i = 0; i < k; i++) {
            int weight = sc.nextInt();
            bagList.add(weight);
        }

        jewelList.sort((o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.value - o1.value;
            }
            return o1.weight - o2.weight;
        });
        bagList.sort(null);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int jewelIdx = 0;
        for (int each : bagList) {
            while (jewelIdx < n && jewelList.get(jewelIdx).weight <= each) {
                pq.offer(jewelList.get(jewelIdx++).value);
            }

            if (!pq.isEmpty()) {
                totalValue += pq.poll();
            }
        }

        System.out.println(totalValue);
    }

    static class Jewel {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
