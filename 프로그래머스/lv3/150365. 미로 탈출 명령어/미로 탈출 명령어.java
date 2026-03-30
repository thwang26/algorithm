public class Solution {
    static int row, col, move;
    static int destX, destY;
    static String result;
    static final String[] dir = {"d", "l", "r", "u"};
    static final int[] dx = {1, 0, 0, -1};
    static final int[] dy = {0, -1, 1, 0};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        row = n;
        col = m;
        destX = r;
        destY = c;
        move = k;
        result = "";

        dfs(x, y, 0, new StringBuilder());
        return result.isEmpty() ? "impossible" : result;
    }

    private void dfs(int x, int y, int steps, StringBuilder path) {
        if (!result.isEmpty()) {
            return;
        }

        int remain = move - steps;
        int dist = Math.abs(x - destX) + Math.abs(y - destY);

        if (dist > remain || (remain - dist) % 2 != 0) {
            return;
        } // 최적화

        if (steps == move) {
            if (x == destX && y == destY) {
                result = path.toString();
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isIn(nx, ny)) {
                path.append(dir[i]);
                dfs(nx, ny, steps + 1, path);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    private boolean isIn(int x, int y) {
        return x >= 1 && x <= row && y >= 1 && y <= col;
    }
}