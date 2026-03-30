import java.util.Arrays;

class Solution {
    int count = 0;
    public int solution(int n) {
        int[] chess = new int[n];

        Arrays.fill(chess, -1);
        makeChess(chess, 0);
        
        return count;
    }

    public void makeChess(int[] chess, int x) {
        if (x == chess.length) {
            count++;
            return;
        }

        int y = 0;
        while (y < chess.length) {
            chess[x] = y;
            if (queenCheck(chess, x)) {
                makeChess(chess, x + 1);
            }
            y++;
        }
    }

    public boolean queenCheck(int[] chess, int x) {
        for (int i = 0; i < x; i++) {
            if (Math.abs(x - i) == Math.abs(chess[x] - chess[i]) ||
            chess[x] == chess[i]) {
                return false;
            }
        }

        return true;
    }
}