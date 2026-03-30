import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    static int row;
    static int col;
    static boolean[][] visited;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int max = Integer.MIN_VALUE;
    static int[][] staticLand;
    static Map<Integer, Integer> map = new HashMap<>();

    static int oilNumber;

    public int solution(int[][] land) {
        staticLand = land;
        row = land.length;
        col = land[0].length;
        visited = new boolean[row][col];
        marking();
        find();
        return max;
    }

    private void find() {
        for (int j = 0; j < col; j++) {
            Set<Integer> set = new HashSet<>();
            int total = 0;
            for (int i = 0; i < row; i++) {
                if (staticLand[i][j] != 0 && !set.contains(staticLand[i][j])) {
                    set.add(staticLand[i][j]);
                    total += map.get(staticLand[i][j]);
                }
            }
            max = Math.max(max, total);
        }
    }

    private void marking() {
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && staticLand[i][j] == 1) {
                    oilNumber++;
                    visited[i][j] = true;
                    staticLand[i][j] = oilNumber;
                    marking(i, j);
                }
            }
        }
    }

    private void marking(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] each : direction) {
                int row = current[0] + each[0];
                int col = current[1] + each[1];
                if (isIn(row, col) && !visited[row][col] && staticLand[row][col] == 1) {
                    visited[row][col] = true;
                    count++;
                    staticLand[row][col] = oilNumber;
                    queue.add(new int[]{row, col});
                }
            }
        }
        map.put(oilNumber, count);
    }

    private boolean isIn(int n, int m) {
        return n >= 0 && n < row && m >= 0 && m < col;
    }
}