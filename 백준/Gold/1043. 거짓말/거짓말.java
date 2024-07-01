import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int party = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < party; i++) {
            queue.add(sc.nextInt());
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> each = new ArrayList<>();
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                each.add(sc.nextInt());
            }
            list.add(each);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < list.size(); i++) {
                List<Integer> each = list.get(i);
                if (each.contains(current)) {
                    queue.addAll(each);
                    list.remove(each);
                    i--;
                }
            }
        }

        System.out.println(list.size());
    }
}
