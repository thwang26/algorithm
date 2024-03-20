import java.util.Scanner;

public class Main {
    static Tetromino[] tetromino = {new One(), new Two(), new Three(), new Four(),
            new Five()};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (Tetromino each : tetromino) {
                    maxValue = Math.max(maxValue, each.getMaxValue(arr, i, j));
                }
            }
        }

        System.out.println(maxValue);
    }

    abstract static class Tetromino {
        int[][] direction;

        int getMaxValue(int[][] arr, int i, int j) {
            int max = 0;
            max = Math.max(max, getRotationValue(arr, i, j));
            symmetry(); // 대칭
            max = Math.max(max, getRotationValue(arr, i, j));

            return max;
        }

        int getRotationValue(int[][] arr, int i, int j) {
            int max = 0;
            for (int idx = 0; idx < 4; idx++) {
                max = Math.max(max, getValue(arr, i, j));
                rotation();
            }

            return max;
        }

        int getValue(int[][] arr, int i, int j) {
            boolean makeAble = true;
            for (int[] each : direction) {
                int y = i + each[0];
                int x = j + each[1];
                if (!isIn(arr, x, y)) {
                    makeAble = false;
                    break;
                }
            }

            int sum = 0;
            if (makeAble) {
                for (int[] each : direction) {
                    int y = i + each[0];
                    int x = j + each[1];
                    sum += arr[y][x];
                }
            }

            return sum;
        }

        void symmetry() {
            for (int i = 0; i < direction.length; i++) {
                direction[i][1] = -direction[i][1];
            }
        }

        void rotation() {
            for (int i = 0; i < direction.length; i++) {
                int temp = direction[i][0];
                direction[i][0] = -direction[i][1];
                direction[i][1] = temp;
            }
        }

        boolean isIn(int[][] arr, int x, int y) {
            return x >= 0 && x < arr[0].length && y >= 0 && y < arr.length;
        }
    }

    static class One extends Tetromino {
        One() {
            super.direction = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}};
        }
    }

    static class Two extends Tetromino {
        Two() {
            super.direction = new int[][]{{0, 0}, {0, 1}, {-1, 1}, {-1, 0}};
        }
    }

    static class Three extends Tetromino {
        Three() {
            super.direction = new int[][]{{0, 0}, {-1, 0}, {-2, 0}, {-2, 1}};
        }
    }

    static class Four extends Tetromino {
        Four() {
            super.direction = new int[][]{{0, 0}, {-1, 0}, {-1, 1}, {-2, 1}};
        }
    }

    static class Five extends Tetromino {
        Five() {
            super.direction = new int[][]{{0, 0}, {0, 1}, {0, 2}, {-1, 1}};
        }
    }
}
