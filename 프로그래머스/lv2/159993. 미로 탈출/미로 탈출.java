import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;

    int count = 0;

    public int solution(String[] maps) {
        int m = maps.length;
        int n = maps[0].length();

        visited = new boolean[m][n];

        int[] startCoordinate = findStart(maps);
        int[] leverCoordinate = findKeyword(maps, startCoordinate, 'L');

        if (leverCoordinate[0] == -1) {
            return -1;
        }

        int[] exitCoordinate = findKeyword(maps, leverCoordinate, 'E');

        if (exitCoordinate[0] == -1) {
            return -1;
        }

        return count;
    }

    public int[] findStart(String[] maps) {
        int[] coordinate = new int[2];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) != 'S') {
                    continue;
                }
                coordinate[0] = i;
                coordinate[1] = j;
                break;
            }
        }

        return coordinate;
    }

    public int[] findKeyword(String[] maps, int[] coo, char keyword) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = copyArr(this.visited);

        queue.add(new Coordinate(coo[1], coo[0], 0));
        visited[coo[0]][coo[1]] = true;
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            if (maps[coordinate.y].charAt(coordinate.x) == keyword) {
                this.count += coordinate.count;
                return new int[]{coordinate.y, coordinate.x};
            }

            for (int[] dir : direction) {
                int nx = coordinate.x + dir[0];
                int ny = coordinate.y + dir[1];

                if (isIn(maps, nx, ny) && !visited[ny][nx]
                        && maps[ny].charAt(nx) != 'X') {
                    queue.add(new Coordinate(nx, ny, coordinate.count + 1));
                    visited[ny][nx] = true;
                }
            }
        }

        return new int[]{-1, -1};
    }

    public boolean isIn(String[] maps, int x, int y) {
        return x >= 0 && x < maps[0].length() && y >= 0 && y < maps.length;
    }

    public boolean[][] copyArr(boolean[][] arr){
        boolean[][] result = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i].clone();
        }

        return result;
    }

    static class Coordinate {
        int x;
        int y;
        int count;

        public Coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
