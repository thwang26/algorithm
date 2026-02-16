import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] l = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.println(sum(l[1]) - sum(l[0] - 1));
    }

    private static long sum(long l) {
        if (l <= 3) {
            return 0;
        }

        if (l % 2 != 0) {
            l--;
        }
        return l / 2 * (l / 2 + 1) - 2;
    }
}
/*
3
4 - o
5
6 - o


2 - 0
4 - 4
6 - 10
8 - 18
10 - 28
12 - 40
14 - 54
 */