import java.util.PriorityQueue;

public class Solution {
    public int solution(int[][] targets) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int[] each : targets) {
            pq.add(each);
        }

        int end = -1;
        int count = 0;
        while (!pq.isEmpty()) {
            int[] each = pq.poll();
            if (each[0] >= end) {
                count++;
                end = each[1];
            } else {
                end = Math.min(end, each[1]);
            }
        }

        return count;
    }
}
