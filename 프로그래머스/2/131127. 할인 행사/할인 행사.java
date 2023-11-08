import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            if (wantMap.containsKey(discount[i])) {
                wantMap.put(discount[i], wantMap.get(discount[i]) - 1);
            }
        }

        int startIdx = 0;
        int endIdx = startIdx + 10 - 1;
        int count = 0;
        while (endIdx < discount.length) {
            if (satisfaction(wantMap)) {
                count++;
            }

            if (wantMap.containsKey(discount[startIdx])) {
                wantMap.put(discount[startIdx], wantMap.get(discount[startIdx]) + 1);
            }

            if (endIdx + 1 != discount.length && wantMap.containsKey(discount[endIdx + 1])) {
                wantMap.put(discount[endIdx + 1], wantMap.get(discount[endIdx + 1]) - 1);
            }

            startIdx++;
            endIdx++;
        }

        return count;
    }

    public boolean satisfaction(Map<String, Integer> map) {
        for (int value: map.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }
}