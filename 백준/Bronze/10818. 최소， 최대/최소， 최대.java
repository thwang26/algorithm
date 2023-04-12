
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

// 백준
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < arr.length ; i++) {
            arr[i] = scan.nextInt();
        }
        for (int i = 0 ; i < arr.length ; i++) {
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
        bw.write(min+" "+max);
        bw.flush();
        bw.close();
        br.close();
    }

}