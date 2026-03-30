import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(Comparator.comparing(map::get));

        int totalTangerine = tangerine.length;
        for (int key : keySet) {
            if (totalTangerine == k) {
                break;
            }

            if (totalTangerine > k && totalTangerine - map.get(key) < k) {
                totalTangerine = k;
                continue;
            }

            totalTangerine -= map.get(key);
            map.remove(key);
        }

        return map.size();
    }
}