import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int operation = 0;

        for (int each : nums) {
            int pair = k - each;
            if (map.containsKey(pair)) {
                int value = map.get(pair);
                operation++;
                if (value - 1 == 0) {
                    map.remove(pair);
                } else {
                    map.put(pair, value - 1);
                }
            } else {
                map.put(each, map.getOrDefault(each, 0) + 1);
            }
        }

        return operation;
    }
}