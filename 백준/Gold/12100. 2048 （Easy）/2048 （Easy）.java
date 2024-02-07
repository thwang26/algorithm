import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static String[] news = {"N", "E", "W", "S"};
    static int maxBlock = 0;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        combination("");
        System.out.println(maxBlock);
    }

    static void combination(String str) {
        if (str.length() == 5) {
            move(str);
            return;
        }

        for (String n : news) {
            combination(str + n);
        }
    }

    static void move(String str) {
        int[][] copyArr = copyArr();

        for (char c : str.toCharArray()) {
            switch (c) {
                case 'N' :
                    moveNorth(copyArr);
                    break;
                case 'E' :
                    moveEast(copyArr);
                    break;
                case 'W' :
                    moveWest(copyArr);
                    break;
                case 'S' :
                    moveSouth(copyArr);
                    break;
            }
        }
    }

    private static void moveSouth(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            Deque<Integer> deque = new ArrayDeque<>();

            boolean merged = false;
            for (int j = arr.length - 1; j >= 0; j--) {
                int n = arr[j][i];

                if (n == 0) {
                    continue;
                }

                if (!deque.isEmpty() && !merged && deque.peekLast() == n) {
                    deque.addLast(deque.pollLast() + n);
                    merged = true;
                } else {
                    deque.addLast(n);
                    merged = false;
                }
            }

            while (deque.size() != arr.length) {
                deque.addLast(0);
            }

            for (int j = arr.length - 1; j >= 0; j--) {
                int n = deque.pollFirst();
                maxBlock = Math.max(maxBlock, n);
                arr[j][i] = n;
            }
        }
    }

    private static void moveWest(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            Deque<Integer> deque = new ArrayDeque<>();

            boolean merged = false;
            for (int j = 0; j < arr.length; j++) {
                int n = arr[i][j];

                if (n == 0) {
                    continue;
                }

                if (!deque.isEmpty() && !merged && deque.peekLast() == n) {
                    deque.addLast(deque.pollLast() + n);
                    merged = true;
                } else {
                    deque.addLast(n);
                    merged = false;
                }
            }

            while (deque.size() != arr.length) {
                deque.addLast(0);
            }

            for (int j = 0; j < arr.length; j++) {
                int n = deque.pollFirst();
                maxBlock = Math.max(maxBlock, n);
                arr[i][j] = n;
            }
        }
    }

    private static void moveEast(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            Deque<Integer> deque = new ArrayDeque<>();

            boolean merged = false;
            for (int j = arr.length - 1; j >= 0; j--) {
                int n = arr[i][j];

                if (n == 0) {
                    continue;
                }

                if (!deque.isEmpty() && !merged && deque.peekLast() == n) {
                    deque.addLast(deque.pollLast() + n);
                    merged = true;
                } else {
                    deque.addLast(n);
                    merged = false;
                }
            }

            while (deque.size() != arr.length) {
                deque.addLast(0);
            }

            for (int j = arr.length - 1; j >= 0; j--) {
                int n = deque.pollFirst();
                maxBlock = Math.max(maxBlock, n);
                arr[i][j] = n;
            }
        }
    }

    private static void moveNorth(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            Deque<Integer> deque = new ArrayDeque<>();

            boolean merged = false;
            for (int j = 0; j < arr.length; j++) {
                int n = arr[j][i];

                if (n == 0) {
                    continue;
                }

                if (!deque.isEmpty() && !merged && deque.peekLast() == n) {
                    deque.addLast(deque.pollLast() + n);
                    merged = true;
                } else {
                    deque.addLast(n);
                    merged = false;
                }
            }

            while (deque.size() != arr.length) {
                deque.addLast(0);
            }

            for (int j = 0; j < arr.length; j++) {
                int n = deque.pollFirst();
                maxBlock = Math.max(maxBlock, n);
                arr[j][i] = n;
            }
        }
    }

    private static int[][] copyArr() {
        int[][] copy = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                copy[i][j] = arr[i][j];
            }
        }

        return copy;
    }
}
