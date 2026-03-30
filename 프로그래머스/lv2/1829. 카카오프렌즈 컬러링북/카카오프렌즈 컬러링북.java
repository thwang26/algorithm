import java.util.*;

class Solution {
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[] solution(int m, int n, int[][] picture) {
        Queue<Pic> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int yLen = picture.length;
        int xLen = picture[0].length;
        boolean[][] visited = new boolean[m][n];
        int key = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }

                visited[i][j] = true;
                queue.add(new Pic(j, i, picture[i][j]));
                if (picture[i][j] != 0) {
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                while (!queue.isEmpty()) {
                    Pic pic = queue.poll();

                    for (int[] dir: direction) {
                        int nx = pic.x + dir[0];
                        int ny = pic.y + dir[1];

                        if (isIn(xLen, yLen, nx, ny) && !visited[ny][nx] && pic.color == picture[ny][nx]) {
                            queue.add(new Pic(nx, ny, picture[ny][nx]));
                            visited[ny][nx] = true;
                            if (picture[ny][nx] != 0) {
                                map.put(key, map.get(key) + 1);
                            }
                        }
                    }
                }
                key++;
            }
        }

        int[] answer = new int[2];
        answer[0] = map.size();
        answer[1] = map.values().stream().filter(number -> number != 0)
                .max(Comparator.comparingInt(o -> o)).get();
        return answer;
    }

    public boolean isIn(int xLen, int yLen, int x, int y) {
        return x >= 0 && x < xLen && y >= 0 && y < yLen;
    }

    static class Pic {
        int x;
        int y;
        int color;

        public Pic(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}