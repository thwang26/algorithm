import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        for (int sco: scoville) {
            pq.add(sco);
        }

        int count = 0;
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }

            pq.add(pq.poll() + pq.poll() * 2);
            count++;
        }

        return count;
    }
}