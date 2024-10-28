import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int minChangeCount = Integer.MAX_VALUE;
    static int[][] arr;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] changeCountArr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        changeCountArr = new int[n][n];
        Arrays.stream(changeCountArr).forEach(each -> Arrays.fill(each, Integer.MAX_VALUE));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.stream(sc.next().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.row == n - 1 && current.col == n - 1) {
                minChangeCount = Math.min(minChangeCount, current.changeCount);
                continue;
            }

            for (int[] dir : direction) {
                int nextRow = current.row + dir[0];
                int nextCol = current.col + dir[1];

                if (isOk(nextRow, nextCol)) {
                    int minChangeCount = changeCountArr[nextRow][nextCol];
                    int nextChangeCount = current.changeCount + (arr[nextRow][nextCol] == 0 ? 1 : 0);
                    if (minChangeCount > nextChangeCount) {
                        changeCountArr[nextRow][nextCol] = nextChangeCount;
                        queue.add(new Node(nextRow, nextCol, nextChangeCount));
                    }
                }
            }
        }

        System.out.println(minChangeCount);
    }

    private static boolean isOk(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    static class Node {
        int row;
        int col;
        int changeCount;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Node(int row, int col, int changeCount) {
            this.row = row;
            this.col = col;
            this.changeCount = changeCount;
        }
    }
}
