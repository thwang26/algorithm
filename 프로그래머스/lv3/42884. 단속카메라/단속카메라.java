import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.addAll(Arrays.asList(routes));

        int count = 0;
        int flag = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (flag < current[0]) {
                count++;
                flag = current[1];
            }
        }

        return count;
    }
}
