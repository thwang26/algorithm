import java.util.*;

public class Main {
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];
        while (m-- > 0) {
            arr[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
        } // 사과 체크

        int k = sc.nextInt();
        List<Move> list = new ArrayList<>();
        while (k-- > 0) {
            list.add(new Move(sc.nextInt(), sc.next()));
        } // 머리방향 체크

        int time = 0;
        Node head = new Node(0, 0, null);
        int headDirection = 1;
        while (true) {
            time++;

            // 몸 길이를 늘림
            Node.increase(head, head.next, headDirection);

            // 벽이나 자기자신에 부딪히는지 확인
            if (!Node.isSafe(head.x, head.y, n)
                    || Node.isEat(head, head.next)) {
                break;
            }

            // 이동한 칸에 사과 확인
            if (arr[head.y][head.x] == 0) {
                Node.removeTail(head);
                // 사과가 아니면 꼬리 줄임
            } else {
                arr[head.y][head.x] = 0;
            } // 사과를 먹으면 사과를 치움

            // 머리 방향 이동
            Move move = null;
            if (!list.isEmpty() && list.get(0).t == time) {
                move = list.remove(0);
            }

            if (move != null) {
                if (move.move.equals("L")) {
                    headDirection += 3;
                } else {
                    headDirection += 1;
                }

                headDirection %= 4;
            } // 현재 시간에 머리 방향을 바꿔야 한다면 바꿈, 오른쪽은 +1, 왼쪽은 +3(-1)
        }

        System.out.println(time);
    }

    static class Move {
        int t;
        String move;

        public Move(int t, String move) {
            this.t = t;
            this.move = move;
        }
    }

    static class Node {
        int x;
        int y;
        Node next;

        public Node(int x, int y, Node node) {
            this.x = x;
            this.y = y;
            this.next = node;
        }

        static boolean isEat(Node head, Node node) {
            if (head.x == node.x && head.y == node.y) {
                return true;
            }

            if (node.next == null) {
                return false;
            }

            return isEat(head, node.next);
        }

        static void increase(Node head, Node neck, int headDirection) {
            Node newNeck = new Node(head.x, head.y, neck);
            int[] dir = direction[headDirection];
            head.x += dir[1];
            head.y += dir[0];
            head.next = newNeck;
        }

        static boolean isSafe(int x, int y, int n) {
            return x >= 0 && x < n && y >= 0 && y < n;
        }

        static void removeTail(Node node) {
            if (node.next.next == null) {
                node.next = null;
                return;
            }

            removeTail(node.next);
        }
    }
}
