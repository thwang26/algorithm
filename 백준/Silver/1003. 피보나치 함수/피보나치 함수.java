import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] c0;
    static int[] c1;

    public static void fibonacci(int n){
        if(n>=1) { c0[1] = 0; c1[1] = 1; }
        c0[0] = 1; c1[0] = 0;

        // 반복문을 사용
        for(int i=2; i<=n; i++){
            // Table을 채워나감
            c0[i] = c0[i-1]+c0[i-2];
            c1[i] = c1[i-1]+c1[i-2];
        }
    }

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine()); //Int
        int n;

        while(t!=0){
            n = Integer.parseInt(br.readLine()); //Int
            c0 = new int[n+1];
            c1 = new int[n+1];
            fibonacci(n);
            bw.write(c0[n]+" "+c1[n]+"\n");
            t--;
        }
        bw.flush();
        bw.close();
    }
}