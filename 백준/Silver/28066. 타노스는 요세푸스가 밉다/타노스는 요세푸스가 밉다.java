import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        IntStream.rangeClosed(1, n).forEach(queue::add);

        while (queue.size() > 1) {
            int first = queue.remove();
            int size = queue.size();

            for (int i = 0; i < Math.min(k - 1, size); i++) {
                queue.remove();
            }

            queue.add(first);
        }

        System.out.println(queue.remove());
    }
}
