import java.util.PriorityQueue;

public class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int round = 0;
        for (int e : enemy) {
            if (k == 0 && n < e) {
                break;
            }
            if (n >= e) {
                pq.add(e);
                n -= e;
            } else {
                if (!pq.isEmpty() && pq.peek() > e) {
                    n += pq.poll();
                    pq.add(e);
                    n -= e;
                }
                k--;
            }
            round++;
        }

        return round;
    }
}