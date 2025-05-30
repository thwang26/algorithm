import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] each : grid) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                sb.append(each[j]).append(".");
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        int count = 0;
        for (int j = 0; j < grid.length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int[] each : grid) {
                sb.append(each[j]).append(".");
            }
            if (map.containsKey(sb.toString())) {
                count += map.get(sb.toString());
            }
        }

        return count;
    }
}