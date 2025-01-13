import java.util.Scanner;

public class Main {
    static int n;
    static int[][] chess;
    static int[][] boardColor;
    static boolean[][] visited;
    static int maxWhite = Integer.MIN_VALUE;
    static int maxBlack = Integer.MIN_VALUE;
    static int[][] direction = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        chess = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = sc.nextInt();
            }
        }

        boardColor = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boardColor[i][j] = (i + j) % 2;
            }
        }

        visited = new boolean[n][n];
        makeChess(0, 0, 0, 0);
        makeChess(0, 1, 1, 0);
        System.out.println(maxWhite + maxBlack);
    }

    private static void makeChess(int row, int col, int color, int count) {
        if (col >= n) {
            row++;
            if (row < n) {
                col = boardColor[row][0] == color ? 0 : 1;
            }
        }

        if (row >= n) {
            if (color == 1) {
                maxWhite = Math.max(maxWhite, count);
            } else {
                maxBlack = Math.max(maxBlack, count);
            }
            return;
        }

        if (chess[row][col] == 1 && boardColor[row][col] == color && bishopCheck(row, col)) {
            visited[row][col] = true;
            makeChess(row, col + 2, color, count + 1);
            visited[row][col] = false;
        }
        makeChess(row, col + 2, color, count);
    }

    private static boolean bishopCheck(int row, int col) {
        for (int[] each : direction) {
            int currentRow = row;
            int currentCol = col;
            while (currentRow >= 0 && currentRow < n && currentCol >= 0 && currentCol < n) {
                if (visited[currentRow][currentCol]) {
                    return false;
                }
                currentRow += each[0];
                currentCol += each[1];
            }
        }
        return true;
    }
}