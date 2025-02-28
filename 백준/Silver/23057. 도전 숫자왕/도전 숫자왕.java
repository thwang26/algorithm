import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Integer> set = new HashSet<>();
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        comb(0, 0);
        System.out.println(Arrays.stream(arr).sum() - set.size());
    }

    private static void comb(int idx, int sum) {
        count++;
        if (sum != 0) {
            set.add(sum);
        }

        if (idx >= arr.length) {
            return;
        }

        comb(idx + 1, sum + arr[idx]);
        comb(idx + 1, sum);
    }
}