import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 백준
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] deci = new int[64];
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int deciCnt = 0;
            while(num != 0) {
                if (num % 2 != 0) {
                    deci[deciCnt]++;
                }
                num /= 2;
                deciCnt++;
            }
        }

        for (int i = 0; i < deci.length; i++) {
            cnt += (long)Math.pow(2, i) * deci[i] * (n - deci[i]);
        }

        System.out.println(cnt);
    }
}