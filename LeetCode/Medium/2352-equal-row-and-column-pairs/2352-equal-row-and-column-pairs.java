import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int[] each : grid) {
            List<Integer> list = Arrays.stream(each)
                    .boxed()
                    .collect(Collectors.toList());
            map.put(list, map.getOrDefault(list, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < grid[0].length; i++) {
            final int j = i;
            List<Integer> list = Arrays.stream(grid)
                    .mapToInt(ints -> ints[j])
                    .boxed().collect(Collectors.toList());
            if (map.containsKey(list)) {
                count += map.get(list);
            }
        }

        return count;
    }
}