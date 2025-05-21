import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == m) {
                count++;
                min = current;
                continue;
            }

            for (int each : new int[]{-1, 1, current}) {
                int next = current + each;
                if (next < 0 || next >= arr.length) {
                    continue;
                }

                if (arr[next] >= arr[current] + 1) {
                    arr[next] = arr[current] + 1;
                    queue.add(next);
                }
            }
        }

        System.out.println(arr[m]);
        System.out.println(count);
    }
}
