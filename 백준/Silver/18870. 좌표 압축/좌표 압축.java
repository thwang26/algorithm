import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sArr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        String[] str = br.readLine().split(" ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        for(int i = 0 ; i < n ; i++){
            sArr[i] = arr[i];
        }
        Arrays.sort(sArr);

        int rank = 0;
        for(int i = 0 ; i < n ; i++){
            if(!map.containsKey(sArr[i])){
                map.put(sArr[i], rank);
                rank++;
            }
        }

        for(int i = 0 ; i < n ; i++){
            arr[i] = map.get(arr[i]);
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}