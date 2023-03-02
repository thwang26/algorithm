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

        int num = 0;

        while(n != 0){
            num++;
            if(Integer.toString(num).contains("666")) n--;
        }

        System.out.println(num);

        // bw.write(i+"\n"); //담아두기
        // bw.flush(); //출력
        // bw.close(); //닫기
    }
}