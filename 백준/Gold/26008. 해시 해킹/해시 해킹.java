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
        Scanner scan = new Scanner(System.in);

        long answer = 1L;

        int n = scan.nextInt();
        int m = scan.nextInt();
        int a = scan.nextInt();
        int h = scan.nextInt();

        for (int i = 0; i < n - 1; i++) {
            answer = (answer * m) % 1000000007;
        }
        System.out.println(answer);
        bw.flush();
        bw.close();
        br.close();
    }

}