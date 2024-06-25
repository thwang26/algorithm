import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        while (n-- > 0) {
            pq.add(sc.nextInt());
        }

        final int[] sum = {0};
        IntStream.range(1, pq.size()).forEach(i -> {
            int a = pq.poll();
            int b = pq.poll();
            sum[0] += a + b;
            pq.add(a + b);
        });

        System.out.println(sum[0]);
    }
}
