import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long A = j - i;
                long B = Math.abs(arr[j] - arr[i]);

                boolean canSee = true;
                for (int k = i + 1; k < j; k++) {
                    if (arr[k] < arr[i] && arr[k] < arr[j]) {
                        continue;
                    }

                    if (B == 0 && arr[k] >= arr[i]) {
                        canSee = false;
                        break;
                    }

                    long a = arr[i] < arr[j] ? k - i : j - k;
                    long b = arr[i] < arr[j] ? arr[k] - arr[i]: arr[k] - arr[j];
                    if (a * B <= b * A) {
                        canSee = false;
                        break;
                    }
                }

                if (canSee) {
                    count[i]++;
                    count[j]++;
                }
            }
        }

        System.out.println(Arrays.stream(count).max().getAsInt());
    }
}
// 둘이 같음
//     1. k가 큼
//     안보임
//     2. k가 작음
//     보임
//     3. k가 없음
//     보임
//     4. k가 같음
//     안보임

// 둘이 다름
//     1. k가 큼
//     계산필요
//     2. k가 작음
//     보임
//     3. k가 없음
//     보임
//     4. k가 하나랑 같음
//     보임