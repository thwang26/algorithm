import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[100_001];
        Arrays.fill(arr, Integer.MAX_VALUE);

        Queue<Integer> pq = new LinkedList<>();
        pq.add(n);
        arr[n] = 0;
        while (!pq.isEmpty()) {
            int value = pq.poll();

            if (value == k) {
                continue;
            }

            for (int each : new int[]{1, -1, value}) {
                int next = each + value;
                if (isIn(value + each)) {
                    if (each == value && arr[next] > arr[value]) {
                        arr[next] = arr[value];
                        pq.add(next);
                    } else if (arr[next] > arr[value] + 1) {
                        arr[next] = arr[value] + 1;
                        pq.add(next);
                    }
                }
            }
        }

        bw.write(String.valueOf(arr[k]));
        bw.flush();
        bw.close();
    }

    private static boolean isIn(int i) {
        return i >= 0 && i <= 100000;
    }
}