import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int one = Math.abs(o1);
            int two = Math.abs(o2);
            if (one == two) {
                return o1 - o2;
            }
            return one - two;
        });

        int n = sc.nextInt();
        while (n-- > 0) {
            int query = sc.nextInt();
            if (query == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(query);
            }
        }
    }
}
