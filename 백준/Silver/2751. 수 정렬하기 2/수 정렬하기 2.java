import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Sort implements Comparable<Sort> {
    
        int num;
    
        Sort(int num){
            this.num = num;
        }
    
        @Override
        public int compareTo(Sort o) {
            if(this.num < o.num)
                return -1;
            else if(this.num > o.num)
                return 1;
            return 0;
        }
    }
    
    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        
        int n = Integer.parseInt(br.readLine());

        Sort[] s = new Sort[n];
        for(int i = 0 ; i < n ; i++){
            s[i] = new Sort(Integer.parseInt(br.readLine()));
        }
        Arrays.sort(s);
        for(int i = 0 ; i < n ; i++){
            //System.out.println(s[i].num);
            bw.write(s[i].num+"\n"); //담아두기
        }
        bw.flush(); //출력
        bw.close(); //닫기
        br.close(); //닫기
    }
}