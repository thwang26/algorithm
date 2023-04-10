import java.io.*;
import java.util.*;
import java.util.stream.Stream;

// 백준
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        for(int i = 1 ; i < arr.length ; i++){
            arr[i] += arr[i-1];
        }
        System.out.println(Arrays.stream(arr).sum());
        br.close();
    }

}