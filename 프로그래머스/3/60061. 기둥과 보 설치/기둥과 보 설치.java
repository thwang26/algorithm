import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static boolean[][][] arr;
    static int length;

    public int[][] solution(int n, int[][] buildFrame) {
        arr = new boolean[n + 5][n + 5][2];
        length = n;

        for (int[] each : buildFrame) {
            Status status = new Status(each[1] + 2, each[0] + 2, each[3] == 1, each[2]);
            set(status);
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 2; i < arr.length - 2; i++) {
            for (int j = 2; j < arr[0].length - 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (!arr[i][j][k]) {
                        continue;
                    }
                    list.add(new int[]{j - 2, i - 2, k});
                }
            }
        }

        list.sort((o1, o2) -> {
            if (o1[0] == o2[0] && o1[1] == o2[1]) {
                return o1[2] - o2[2];
            }

            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        return list.toArray(int[][]::new);
    }

    private void set(Status status) {
        arr[status.row][status.col][status.type] = status.build;
        if (!valid()) {
            arr[status.row][status.col][status.type] = !status.build;
        }
    }

    private boolean valid() {
        for (int i = 2; i < arr.length - 2; i++) {
            for (int j = 2; j < arr[0].length - 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (arr[i][j][k]) {
                        Status each = new Status(i, j, true, k);
                        if (k == 0 && !pillarCheck(each)) {
                            return false;
                        }
                        if (k == 1 && !boCheck(each)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean pillarCheck(Status status) {
        return status.row == 2
                || arr[status.row - 1][status.col][status.Pillar]
                || arr[status.row][status.col - 1][status.Bo]
                || arr[status.row][status.col][status.Bo];
    }

    private boolean boCheck(Status status) {
        return (arr[status.row - 1][status.col][status.Pillar]
                || arr[status.row - 1][status.col + 1][status.Pillar])
                || (arr[status.row][status.col - 1][status.Bo]
                && arr[status.row][status.col + 1][status.Bo]);
    }

    public boolean isIn(int row, int col) {
        return row >= 0 && row <= length && col >= 0 && col <= length;
    }

    static class Status {
        int row;
        int col;
        boolean build;
        int type;
        final int Bo = 1;
        final int Pillar = 0;

        public Status(int row, int col, boolean build, int type) {
            this.row = row;
            this.col = col;
            this.build = build;
            this.type = type;
        }
    }
}