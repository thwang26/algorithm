import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int pivot = getPivot();
        int bigger = getBigger(pivot);
        if (pivot == -1 || bigger == -1) {
            System.out.println(-1);
            return;
        }

        int tmp;
        tmp = arr[pivot];
        arr[pivot] = arr[bigger];
        arr[bigger] = tmp;

        int[] order = Arrays.copyOfRange(arr, pivot + 1, arr.length);
        Arrays.sort(order);

        for (int i = pivot + 1; i < arr.length; i++) {
            arr[i] = order[i - pivot - 1];
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    private static int getBigger(int pivot) {
        if (pivot == -1) {
            return -1;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[pivot] < arr[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int getPivot() {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}