import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int minCount = Integer.MAX_VALUE;

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
                    marbleBoard.red = new MarbleBoard.Red(j, i);
                }

                if (marbleBoard.board[i][j].equals("B")) {
                    marbleBoard.blue = new MarbleBoard.Blue(j, i);
                }
            }
        }

        dfs(marbleBoard, 0);
        System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
    }

    static void dfs(MarbleBoard board, int count) {
        // 다 되었는지
        if (board.blue.x == -1 && board.blue.y == -1) {
            return;
        }

        if (board.red.x == -1 && board.red.y == -1) {
            minCount = Math.min(minCount, count);
            return;
        }

        // 횟수제한
        if (count >= 10) {
            return;
        }

        for (int i = 1; i <= 4; i++) {
            MarbleBoard copy = copyBoard(board);
            move(copy, i);

            if (Arrays.deepEquals(board.board, copy.board)) {
                continue;
            } // 무효횟수 무시

            dfs(copy, count + 1);
        }
    }

    static void move(MarbleBoard board, int i) {
        // 1동, 2서, 3남, 4북
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

    private static MarbleBoard copyBoard(MarbleBoard board) {
        MarbleBoard copy = new MarbleBoard();
        String[][] arr = new String[board.board.length][board.board[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = board.board[i][j];
            }
        }

        copy.board = arr;
        copy.red = new MarbleBoard.Red(board.red.x, board.red.y);
        copy.blue = new MarbleBoard.Blue(board.blue.x, board.blue.y);

        return copy;
    }

    static void move(MarbleBoard board, Marble marble, int xMove, int yMove) {
        board.board[marble.getY()][marble.getX()] = ".";
        while (true) {
            int nx = marble.getX() + xMove;
            int ny = marble.getY() + yMove;

            if (board.board[ny][nx].equals("O")) {
                marble.setY(-1);
                marble.setX(-1);
                return;
            }

            if (!board.board[ny][nx].equals(".")) {
                board.board[marble.getY()][marble.getX()] = marble.getColor();
                break;
            }

            marble.setY(ny);
            marble.setX(nx);
        }
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

    interface Marble {
        String getColor();

        int getX();

        int getY();

        void setX(int x);

        void setY(int y);
    }

    static class MarbleBoard {
        String[][] board;
        public MarbleBoard.Red red;
        public MarbleBoard.Blue blue;

        static class Red implements Marble {
            int x;
            int y;

            public Red(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public String getColor() {
                return "R";
            }

            public int getX() {
                return this.x;
            }

            public int getY() {
                return this.y;
            }

            public void setX(int x) {
                this.x = x;
            }

            public void setY(int y) {
                this.y = y;
            }
        }

        static class Blue implements Marble {
            int x;
            int y;

            public Blue(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public String getColor() {
                return "B";
            }

            public int getX() {
                return this.x;
            }

            public int getY() {
                return this.y;
            }

            public void setX(int x) {
                this.x = x;
            }

            public void setY(int y) {
                this.y = y;
            }
        }
    }
}
