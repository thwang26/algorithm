class Solution {
    int totalZero = 0;
    int totalOne = 0;
    public int[] solution(int[][] arr) {
        recur(0, 0, arr[0].length, arr);
        return new int[]{totalZero, totalOne};
    }

    public void recur(int x, int y, int n, int[][] arr) {
        int count = 0;

        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }

        if (count == 0) {
            totalZero++;
            return;
        }

        if (count == n * n) {
            totalOne++;
            return;
        }

        n /= 2;
        recur(x, y, n, arr);
        recur(x, y + n, n, arr);
        recur(x + n, y, n, arr);
        recur(x + n, y + n, n, arr);
    }
}