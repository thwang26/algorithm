import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map = new char[h + 2][w + 2];
            for (char[] chars : map) {
                Arrays.fill(chars, '.');
            }

            for (int i = 1; i < map.length - 1; i++) {
                char[] arr = br.readLine().toCharArray();
                for (int j = 1; j < map[0].length - 1; j++) {
                    map[i][j] = arr[j - 1];
                }
            }

            String key = br.readLine();
            find(map, key);
            sb.append(count).append('\n');
            count = 0;
        }

        System.out.println(sb);
    }

    private static void find(char[][] map, String key) {
        boolean[] keyArr = new boolean[26];
        if (!key.equals("0")) {
            for (char c : key.toCharArray()) {
                keyArr[c - 'a'] = true;
            }
        }

        Set<int[]> lockedDoor = new HashSet<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        boolean updated = true;
        while (updated) {
            updated = bfs(lockedDoor, visited, map, keyArr, queue);
        }
    }

    private static boolean bfs(Set<int[]> lockedDoor, boolean[][] visited, char[][] map, boolean[] keyArr,
                               Queue<int[]> queue) {
        boolean updated = false;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] each : direction) {
                int row = current[0] + each[0];
                int col = current[1] + each[1];

                if (!isIn(row, col, map.length, map[0].length)) {
                    continue;
                }

                if (visited[row][col] || map[row][col] == '*') {
                    continue;
                }

                char c = map[row][col];

                if (c >= 'A' && c <= 'Z') {
                    if (keyArr[c - 'A']) {
                        visited[row][col] = true;
                        queue.add(new int[]{row, col});
                        updated = true;
                    } else {
                        lockedDoor.add(new int[]{row, col});
                    }
                } else {
                    if (c >= 'a' && c <= 'z') {
                        keyArr[c - 'a'] = true;
                    } else if (c == '$') {
                        count++;
                    }
                    visited[row][col] = true;
                    queue.add(new int[]{row, col});
                    updated = true;
                }
            }
        }

        Iterator<int[]> i = lockedDoor.iterator();
        while (i.hasNext()) {
            int[] door = i.next();
            char c = map[door[0]][door[1]];
            if (keyArr[c - 'A']) {
                queue.add(door);
                visited[door[0]][door[1]] = true;
                i.remove();
                updated = true;
            }
        }

        return updated;
    }

    private static boolean isIn(int row, int col, int h, int w) {
        return row >= 0 && row < h && col >= 0 && col < w;
    }
}