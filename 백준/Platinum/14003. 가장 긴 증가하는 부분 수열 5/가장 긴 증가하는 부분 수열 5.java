import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {
    static List<Integer> lis = new ArrayList<>();
    static List<int[]> lisHistory = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        search(arr);

        int idx = lis.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = lisHistory.size() - 1; i >= 0; i--) {
            if (idx == lisHistory.get(i)[0]) {
                stack.push(lisHistory.get(i)[1]);
                idx--;
            }

            if (idx < 0) {
                break;
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis.size()).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    private static void search(int[] arr) {
        lis.add(arr[0]);
        lisHistory.add(new int[]{0, arr[0]});
        for (int each : arr) {
            int idx = Collections.binarySearch(lis, each);

            if (idx < 0) {
                idx = -idx - 1;
            }

            if (idx == lis.size()) {
                lis.add(each);
            } else {
                lis.set(idx, each);
            }

            lisHistory.add(new int[]{idx, each});
        }
    }
}