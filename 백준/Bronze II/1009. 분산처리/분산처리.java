import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        int a;
        int b;
        long num;

        while(t!=0){
            a = scan.nextInt();
            b = scan.nextInt();
            num = 1;
            for(int i = 0 ; i < b ; i++){
                num *= a;
                num = num%10; // 어차피 맨 끝 수만 보면 됨
            }
            t--;
            if(num == 0) num = 10;
            bw.write(num+"\n");
        }
        bw.flush();
        bw.close();
    }
}