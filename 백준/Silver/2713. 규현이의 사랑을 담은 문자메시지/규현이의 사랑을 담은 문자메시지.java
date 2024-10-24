import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            String message = sc.nextLine().trim();
            System.out.println(makeMessage(row, col, message));
        }
    }

    private static String makeMessage(int row, int col, String message) {
        String[][] arr = new String[row][col];
        TotalDirection direction = new TotalDirection(row, col);
        String binary = messageToBinary(message, row * col);
        for (int i = 0; i < binary.length(); i++) {
            arr[direction.currentRow][direction.currentCol] = String.valueOf(binary.charAt(i));
            direction.visited[direction.currentRow][direction.currentCol] = true;
            direction.move();
        }

        return Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .collect(Collectors.joining());
    }

    private static String messageToBinary(String message, int totalLength) {
        StringBuilder binary = new StringBuilder();
        for (char c : message.toCharArray()) {
            int atm = alphabetToNumber(c);
            binary.append(String.format("%5s", Integer.toBinaryString(atm)).replace(' ', '0'));
        }
        binary.append("0".repeat(totalLength - binary.length()));
        return binary.toString();
    }

    private static int alphabetToNumber(char c) {
        if (c == ' ') {
            return 0;
        }

        return c - 'A' + 1;
    }

    static class TotalDirection {
        int currentRow;
        int currentCol;
        int row;
        int col;
        boolean[][] visited;
        Direction direction = Direction.getDirection();

        public TotalDirection(int row, int col) {
            this.row = row;
            this.col = col;
            this.visited = new boolean[row][col];
        }

        public boolean canMove() {
            int nextRow = currentRow + direction.rowValue;
            int nextCol = currentCol + direction.colValue;
            return nextRow >= 0 && nextRow < row
                    && nextCol >= 0 && nextCol < col
                    && !visited[nextRow][nextCol];
        }

        public void move() {
            if (!canMove()) {
                direction = direction.next;
            }
            currentRow += direction.rowValue;
            currentCol += direction.colValue;
        }
    }

    static class Direction {
        int rowValue;
        int colValue;
        Direction next;

        public Direction(int rowValue, int colValue) {
            this.rowValue = rowValue;
            this.colValue = colValue;
        }

        static Direction getDirection() {
            Direction east = new Direction(0, 1);
            Direction west = new Direction(0, -1);
            Direction south = new Direction(1, 0);
            Direction north = new Direction(-1, 0);
            east.next = south;
            south.next = west;
            west.next = north;
            north.next = east;

            return east;
        }
    }
}
