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
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int b = Integer.parseInt(str[2]);
        int[][] arr = new int[n][m];
        long nSum = 0;
        int height = 256;
        int heightMax = Integer.MIN_VALUE;
        int cnt = 0;
        int cntMin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int[] arr2: arr) {
            for (int num: arr2) {
                nSum += num;
            }
        }
        nSum += b;

        for (; height >= 0; height--) {
            int iSum = n * m * height;
            cnt = 0;
            if (nSum >= iSum) {
                for (int[] arr2: arr) {
                    for (int num: arr2) {
                        int calGround = height - num;
                        cnt += calGround >= 0 ? calGround: -1 * calGround * 2;
                    }
                }
                if (cnt < cntMin) {
                    cntMin = cnt;
                    heightMax = height;
                } else if (cnt == cntMin && heightMax < height) {
                    heightMax = height;
                }
            }
        }
        System.out.println(cntMin + " " + heightMax);
    }
}