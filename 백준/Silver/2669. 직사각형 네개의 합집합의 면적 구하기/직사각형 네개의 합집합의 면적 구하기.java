import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] square = new int[101][101];
        for (int i = 0; i < 4; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = arr[1]; j < arr[3]; j++) {
                for (int k = arr[0]; k < arr[2]; k++) {
                    square[j][k] = 1;
                }
            }
        }

        System.out.println(Arrays.stream(square).flatMapToInt(Arrays::stream).sum());
    }
}
