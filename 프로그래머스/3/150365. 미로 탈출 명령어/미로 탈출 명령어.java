public class Solution {
    static int row;
    static int col;
    static int move;
    static int destX;
    static int destY;
    static String result = "";
    static String[] dir = {"d", "l", "r", "u"};
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        row = n;
        col = m;
        destX = r;
        destY = c;
        move = k;
        int distance = Math.abs(x - destX) + Math.abs(y - destY);
        if (distance > move) {
            return "impossible";
        }

        recursion(x, y, 0, "");
        return result.isEmpty() ? "impossible" : result;
    }

    private void recursion(int x, int y, int current, String command) {
        int distance = Math.abs(x - destX) + Math.abs(y - destY);
        int remain = move - current;
        if (distance > remain
                || (distance - remain) % 2 != 0
                || !result.isEmpty()) {
            return;
        }

        if (current == move) {
            if (x == destX && y == destY) {
                result = command;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isIn(nx, ny)) {
                recursion(nx, ny, current + 1, command + dir[i]);
            }
        }
    }

    private boolean isIn(int nx, int ny) {
        return nx >= 1 && nx <= row && ny >= 1 && ny <= col;
    }
}