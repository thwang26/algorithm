import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int max = 0;
        int maxIdx = 0;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[idx] = value;
            if (max < value) {
                max = value;
                maxIdx = idx;
            }
        }

        int maxValue = 0;
        int area = 0;
        for (int i = 0; i < maxIdx; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
            area += maxValue;
        }

        maxValue = 0;
        for (int i = arr.length - 1; i > maxIdx; i--) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
            area += maxValue;
        }

        area += arr[maxIdx];
        System.out.println(area);
    }
}
