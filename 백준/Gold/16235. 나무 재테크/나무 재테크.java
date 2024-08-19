import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}};
    static int[][] insertEnergy;
    static int[][] currentEnergy;
    static List<Integer>[][] treeMap;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        insertEnergy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                insertEnergy[i][j] = sc.nextInt();
            }
        }

        currentEnergy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                currentEnergy[i][j] += 5;
            }
        }

        treeMap = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                treeMap[i][j] = new ArrayList<>();
            }
        }

        while (m-- > 0) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int age = sc.nextInt();
            treeMap[y][x].add(age);
        }

        while (k-- > 0) {
            springSummer();
            autumn();
            winter();
        }

        System.out.println(Arrays.stream(treeMap).flatMap(Arrays::stream).mapToInt(List::size).sum());
    }

    public static void springSummer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> current = treeMap[i][j];
                current.sort(Comparator.comparingInt(Integer::intValue));
                List<Integer> temp = new ArrayList<>();
                int deadTree = 0;
                for (int each : current) {
                    if (currentEnergy[i][j] >= each) {
                        currentEnergy[i][j] -= each;
                        each++;
                        temp.add(each);
                    } else {
                        deadTree += each / 2;
                    }
                }

                treeMap[i][j].clear();
                treeMap[i][j].addAll(temp);
                currentEnergy[i][j] += deadTree;
            }
        }
    }

    public static void autumn() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> current = treeMap[i][j];
                for (int e : current) {
                    if (e % 5 == 0) {
                        for (int[] dir : direction) {
                            int ny = dir[0] + i;
                            int nx = dir[1] + j;
                            if (isOk(ny, nx)) {
                                treeMap[ny][nx].add(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                currentEnergy[i][j] += insertEnergy[i][j];
            }
        }
    }

    private static boolean isOk(int ny, int nx) {
        return ny >= 0 && ny < n && nx >= 0 && nx < n;
    }

}
