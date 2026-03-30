import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });

        int hash = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            int[] tuple = data[i];
            int sum = 0;
            for (int n: tuple) {
                sum += n % (i + 1);
            }
            hash = hash ^ sum;
        }

        return hash;
    }
}
