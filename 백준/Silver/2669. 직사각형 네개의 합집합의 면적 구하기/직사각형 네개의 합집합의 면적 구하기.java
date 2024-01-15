import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int xMax = 0;
        int yMax = 0;
        for (int i = 0; i < 4; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            xMax = Math.max(xMax, arr[2]);
            yMax = Math.max(yMax, arr[3]);
            list.add(arr);
        }

        int[][] square = new int[yMax + 1][xMax + 1];
        for (int[] arr : list) {
            for (int i = arr[1]; i < arr[3]; i++) {
                for (int j = arr[0]; j < arr[2]; j++) {
                    square[i][j] = 1;
                }
            }
        }
        
        System.out.println(Arrays.stream(square).flatMapToInt(Arrays::stream).sum());
    }
}
