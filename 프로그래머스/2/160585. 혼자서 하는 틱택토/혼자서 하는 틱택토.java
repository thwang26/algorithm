class Solution {
    public int solution(String[] board) {
        int countO = 0;
        int countX = 0;

        for (String str : board) {
            String[] arr = str.split("");
            for (String str2 : arr) {
                if (str2.equals("O")) {
                    countO++;
                } else if (str2.equals("X")) {
                    countX++;
                }
            }
        }

        if (countX > countO) {
            return 0;
        }

        if (countO - countX > 1) {
            return 0;
        }

        boolean checkO = check(board, "O");
        boolean checkX = check(board, "X");
        if (countX == countO && checkO) {
            return 0;
        }

        if (countX != countO && checkX) {
            return 0;
        }

        return 1;
    }

    public boolean check(String[] board, String keyword) {
        char c = keyword.charAt(0);
        for (int i = 0; i < board.length; i++) {
            if (board[0].charAt(i) == c &&
                    board[1].charAt(i) == c &&
                    board[2].charAt(i) == c) {
                return true;
            }

            if (board[i].equals(keyword.repeat(3))) {
                return true;
            }

        }

        return (board[0].charAt(0) == c &&
                board[1].charAt(1) == c &&
                board[2].charAt(2) == c) ||
                (board[0].charAt(2) == c &&
                        board[1].charAt(1) == c &&
                        board[2].charAt(0) == c);
    }
}