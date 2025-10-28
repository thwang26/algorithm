import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int gap = y - x;
        solution(gap);
    }

    public static void solution(int gap) {
        if (gap == 0) {
            System.out.println(0);
            return;
        }
        int maxHeight = (int) Math.sqrt(gap);
        int extra = gap - (int) Math.pow(maxHeight, 2);
        int extraCount = extra % maxHeight == 0 ? extra / maxHeight : extra / maxHeight + 1;
        System.out.println(maxHeight + maxHeight - 1 + extraCount);
    }
}