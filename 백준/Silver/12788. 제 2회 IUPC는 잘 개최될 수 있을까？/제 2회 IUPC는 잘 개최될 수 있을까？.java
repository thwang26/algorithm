import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            int a = Integer.parseInt(st.nextToken());
            list.add(a);
        }

        list.sort(Comparator.reverseOrder());
        int count = 0;
        int sum = 0;
        for (int each : list) {
            sum += each;
            count++;

            if (sum >= m * k) {
                System.out.println(count);
                return;
            }
        }

        System.out.println("STRESS");
    }
}
