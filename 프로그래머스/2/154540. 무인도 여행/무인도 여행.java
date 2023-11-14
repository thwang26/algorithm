import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[] solution(String[] maps) {
        if (onlyX(maps)) {
            return new int[]{-1};
        }

        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for (int y = 0; y < maps.length; y++) {
            for (int x = 0; x < maps[0].length(); x++) {
                if (!isX(maps, x, y) && !isVisited(visited, x, y)) {
                    int islandSum = findIsland(maps, visited, x, y);
                    list.add(islandSum);
                }
            }
        }
        list.sort(Comparator.comparingInt(o -> o));

        return listToArray();
    }

    public int findIsland(String[] maps, boolean[][] visited, int startX, int startY) {
        Queue<Coordinate> queue = new LinkedList<>();
        int islandSum = 0;

        queue.add(new Coordinate(startX, startY));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            islandSum += (maps[coordinate.y].charAt(coordinate.x) - '0');

            for (int[] dir : direction) {
                int nx = coordinate.x + dir[0];
                int ny = coordinate.y + dir[1];

                if (isIn(maps, nx, ny) && !isX(maps, nx, ny) && !isVisited(visited, nx, ny)) {
                    visited[ny][nx] = true;
                    queue.add(new Coordinate(nx, ny));
                }
            }
        }

        return islandSum;
    }

    public int[] listToArray() {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean onlyX(String[] maps) {
        return Arrays.stream(maps)
                .allMatch(map -> map.chars().allMatch(c -> c == 'X'));
    }

    public boolean isX(String[] maps, int x, int y) {
        return maps[y].charAt(x) == 'X';
    }

    public boolean isVisited(boolean[][] visited, int x, int y) {
        return visited[y][x];
    }

    public boolean isIn(String[] maps, int x, int y) {
        return x >= 0 && x < maps[0].length() && y >= 0 && y < maps.length;
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}