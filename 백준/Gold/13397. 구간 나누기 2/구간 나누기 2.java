import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        br.close();

        int left = 0;
        int right = findMax(arr);
        while (left < right) {
            int mid = (left + right) / 2;
            if (findPartition(mid, arr) <= m) { // 파티션이 같거나 작으면 값 줄여줌
                right = mid;
            } else { // 파티션 개수가 많으면 값 늘려줌
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int n :
                arr) {
            max = Math.max(max, n);
        }
        return max;
    }

    private static int findPartition(int mid, int[] arr) {
        int count = 1;
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if (max - min > mid) {
                count++;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                i--;
            }
        }
        return count;
    }
}
