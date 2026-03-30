import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[] solution(String[][] places) {
        int o = places.length;
        int m = places[0].length;
        int n = places[0][0].length();
        int[] answer = new int[o];

        for (int k = 0; k < o; k++) {
            boolean[][] visited = new boolean[m][n];
            boolean coronaSafe = true;

            Loop:
            for (int i = 0; i < m; i++) {
                String[] place = places[k];

                for (int j = 0; j < n; j++) {
                    if (place[i].charAt(j) != 'P') {
                        continue;
                    }

                    Queue<Seat> queue = new LinkedList<>();
                    visited[i][j] = true;
                    queue.add(new Seat(j, i, 0));
                    while (!queue.isEmpty()) {
                        Seat seat = queue.poll();

                        if (seat.distance == 2) {
                            continue;
                        }

                        for (int[] dir : direction) {
                            int nx = seat.x + dir[0];
                            int ny = seat.y + dir[1];
                            if (isIn(nx, ny, n, m) && !visited[ny][nx]) {
                                if (seat.distance <= 1 && place[ny].charAt(nx) == 'P') {
                                    coronaSafe = false;
                                    break Loop;
                                }

                                if (place[ny].charAt(nx) == 'O') {
                                    visited[ny][nx] = true;
                                    queue.add(new Seat(nx, ny, seat.distance + 1));
                                }
                            }
                        }
                    }
                }
            }
            answer[k] = coronaSafe ? 1 : 0;
        }

        return answer;
    }

    public boolean isIn(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static class Seat {
        int x;
        int y;
        int distance;

        public Seat(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}