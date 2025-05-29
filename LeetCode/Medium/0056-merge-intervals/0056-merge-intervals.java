import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (result.isEmpty() || result.get(result.size() - 1)[1] < current[0]) {
                result.add(current);
            } else {
                int[] a = result.get(result.size() - 1);
                a[1] = Math.max(a[1], current[1]);
                result.set(result.size() - 1, a);
            }
        }

        return result.toArray(int[][]::new);
    }
}