import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static long min = Long.MAX_VALUE;
    static int minLeft;
    static int minMid;
    static int minRight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    minLeft = i;
                    minMid = left;
                    minRight = right;
                }

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    break;
                }
            }
        }
        System.out.println(arr[minLeft] + " " + arr[minMid] + " " + arr[minRight]);
    }
}