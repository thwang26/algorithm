import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int minChickenDistance = Integer.MAX_VALUE;
    static List<Coordinate> houseList = new ArrayList<>();
    static List<Coordinate> chickenList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();

                if (num == 2) {
                    chickenList.add(new Coordinate(j, i));
                }
                if (num == 1) {
                    houseList.add(new Coordinate(j, i));
                }
            }
        }

        combination(m, 0, 0);
        System.out.println(minChickenDistance);
    }

    static void combination(int m, int count, int idx) {
        if (count == m) {
            calDistance();
            return;
        }

        for (int i = idx; i < chickenList.size(); i++) {
            Coordinate coordinate = chickenList.get(i);
            coordinate.open = true;
            combination(m, count + 1, i + 1);
            coordinate.open = false;
        }
    }

    static void calDistance() {
        int chickenDistance = 0;
        for (Coordinate house : houseList) {
            if (chickenDistance >= minChickenDistance) {
                break;
            }

            int currentMinDistance = Integer.MAX_VALUE;
            for (Coordinate chicken : chickenList) {
                if (!chicken.open) {
                    continue;
                }

                currentMinDistance = Math.min(currentMinDistance,
                        Coordinate.calCoordinate(house, chicken));
            }
            chickenDistance += currentMinDistance;
        }

        minChickenDistance = Math.min(minChickenDistance, chickenDistance);
    }

    static class Coordinate {
        int x;
        int y;
        boolean open;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static int calCoordinate(Coordinate a, Coordinate b) {
            return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
        }
    }
}
