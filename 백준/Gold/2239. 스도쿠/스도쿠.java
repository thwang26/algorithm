import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean isPrinted = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            sudoku[i] = Arrays.stream(sc.next().split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }

        makeSudoku(sudoku);
    }

    private static void makeSudoku(int[][] sudoku) {
        int[] coordinate = findZero(sudoku);

        if (isPrinted) {
            return;
        }

        if (Arrays.equals(coordinate, new int[]{-1, -1})) {
            printSudoku(sudoku);
            isPrinted = true;
            return;
        }

        int n = 1;
        while (n < 10) {
            sudoku[coordinate[0]][coordinate[1]] = n;

            if (checkSudoku(sudoku, coordinate, n)) {
                makeSudoku(sudoku);
            }
            sudoku[coordinate[0]][coordinate[1]] = 0;
            n++;
        }
    }

    private static int[] findZero(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    private static boolean checkSudoku(int[][] sudoku, int[] coordinate,
                                       int n
    ) {
        for (int i = 0; i < 9; i++) {
            if (i != coordinate[0] && sudoku[i][coordinate[1]] == n) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != coordinate[1] && sudoku[coordinate[0]][i] == n) {
                return false;
            }
        }

        int row = findRowCol(coordinate[0]);
        int col = findRowCol(coordinate[1]);
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (i != coordinate[0] && j != coordinate[1]
                        && sudoku[i][j] == n) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int findRowCol(int n) {
        return (n / 3) * 3;
    }

    private static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }
    }
}
