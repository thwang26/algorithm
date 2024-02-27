import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int minCount = Integer.MAX_VALUE;
    static String finalWay;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        MarbleBoard marbleBoard = new MarbleBoard();
        marbleBoard.board = new String[n][m];
        for (int i = 0; i < n; i++) {
            marbleBoard.board[i] = sc.next().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (marbleBoard.board[i][j].equals("R")) {
                    marbleBoard.red = new Marble(j, i, "R");
                }

                if (marbleBoard.board[i][j].equals("B")) {
                    marbleBoard.blue = new Marble(j, i, "B");
                }
            }
        }

        dfs(marbleBoard, 0, "", -1);
        System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);

//        if (!Objects.isNull(finalWay)) {
//            System.out.println(finalWay);
//        }
    }

    static void dfs(MarbleBoard board, int count, String way, int before) {
        // 다 되었는지
        if (board.blue.x == -1 && board.blue.y == -1) {
            return;
        }

        if (board.red.x == -1 && board.red.y == -1) {
            if (count < minCount) {
                minCount = count;
                finalWay = way;
            }
            return;
        }

        // 횟수제한
        if (count >= 25) {
            return;
        }

        for (int i = 1; i <= 4; i++) {
            if (before != -1 && (before == i || before + i <= 3 || before + i >= 7)) {
                continue;
            }

            MarbleBoard copy = copyBoard(board);
            move(copy, i);

            if (Arrays.deepEquals(board.board, copy.board)) {
                continue;
            } // 무효횟수 무시

            if (count + 1 < minCount) {
                dfs(copy, count + 1, way + i, i);
            }
        }
    }

    static void move(MarbleBoard board, int i) {
        // R동, L서, D남, U북
        int xMove = i == 1 ? 1 : i == 2 ? -1 : 0;
        int yMove = i == 3 ? 1 : i == 4 ? -1 : 0;

        boolean redFirst = check(board, i);

        if (redFirst) {
            move(board, board.red, xMove, yMove);
            move(board, board.blue, xMove, yMove);
        } else {
            move(board, board.blue, xMove, yMove);
            move(board, board.red, xMove, yMove);
        }
    }

    static void move(MarbleBoard board, Marble marble, int xMove, int yMove) {
        board.board[marble.y][marble.x] = ".";
        while (true) {
            int nx = marble.x + xMove;
            int ny = marble.y + yMove;

            if (board.board[ny][nx].equals("O")) {
                marble.x = -1;
                marble.y = -1;
                return;
            }

            if (!board.board[ny][nx].equals(".")) {
                board.board[marble.y][marble.x] = marble.color;
                break;
            }

            marble.x = nx;
            marble.y = ny;
        }
    }

    static MarbleBoard copyBoard(MarbleBoard board) {
        MarbleBoard copy = new MarbleBoard();
        String[][] arr = new String[board.board.length][board.board[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = board.board[i][j];
            }
        }

        copy.board = arr;
        copy.red = new Marble(board.red.x, board.red.y, "R");
        copy.blue = new Marble(board.blue.x, board.blue.y, "B");

        return copy;
    }

    static boolean check(MarbleBoard board, int i) {
        if ((i == 1 || i == 2) && board.blue.y == board.red.y
                && (i == 1 && board.blue.x > board.red.x)
                || (i == 2 && board.blue.x < board.red.x)) {
            return false;
        }

        if ((i == 3 || i == 4) && board.blue.x == board.red.x
                && (i == 3 && board.blue.y > board.red.y)
                || (i == 4 && board.blue.y < board.red.y)) {
            return false;
        }

        return true;
    }

    static class Marble {
        int x;
        int y;
        String color;

        public Marble(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    static class MarbleBoard {
        String[][] board;
        public Marble red;
        public Marble blue;
    }
}
