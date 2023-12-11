import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        int idx = 0;
        while (idx < progresses.length) {
            int count = 1;
            int remainProgress = 100 - progresses[idx];
            int day = remainProgress % speeds[idx] == 0
                    ? remainProgress / speeds[idx] : remainProgress / speeds[idx] + 1;
            idx++;
            while (idx < progresses.length && progresses[idx] + speeds[idx] * day >= 100) {
                count++;
                idx++;
            }

            answer.add(count);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}