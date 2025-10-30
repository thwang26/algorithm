import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 0 || n % 5 == 0) {
            System.out.println(-1);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        int startNum = 1;
        getMod(set, startNum, n);
    }

    private static void getMod(HashSet<Integer> set, int startNum, int n) {
        if (set.contains(startNum)) {
            System.out.println(-1);
            return;
        }
        startNum %= n;
        if (startNum == 0) {
            System.out.println(count);
            return;
        }
        set.add(startNum);
        count++;
        getMod(set, startNum * 10 + 1, n);
    }
}
