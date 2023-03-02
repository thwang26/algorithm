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

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[100001];

        for(int i = 0 ; i < n ; i++){
            arr[Integer.parseInt(br.readLine())]++;
        }
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i]==0) continue;
            while(true){
                bw.write(i+"\n"); //담아두기
                n--;
                arr[i]--;
                if(arr[i]==0) break;
            }
            if(n==0) break;
        }
        bw.flush(); //출력
        bw.close(); //닫기
    }
}