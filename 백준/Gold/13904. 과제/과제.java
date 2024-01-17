import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Homework> pq = new PriorityQueue<>((o1, o2) -> o2.score - o1.score);
        while (n-- > 0) {
            int day = sc.nextInt();
            int score = sc.nextInt();
            pq.add(new Homework(day, score));
        }

        int[] arr = new int[1001];
        while (!pq.isEmpty()) {
            Homework homework = pq.poll();

            for (int i = homework.day; i >= 1; i--) {
                if (homework.score > arr[i]) {
                    arr[i] = homework.score;
                    break;
                }
            }
        }

        System.out.println(Arrays.stream(arr).sum());
    }

    static class Homework {
        int day;
        int score;

        public Homework(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }
}