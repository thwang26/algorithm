import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static Set<Integer> set = new HashSet<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        comb();
        System.out.println(Arrays.stream(arr).sum() - set.size() + 1);
    }

    private static void comb() {
        set.add(0);
        for (int num : arr) {
            List<Integer> temp = new ArrayList<>();
            for (int sum : set) {
                temp.add(sum + num);
            }
            set.addAll(temp);
        }
    }
}