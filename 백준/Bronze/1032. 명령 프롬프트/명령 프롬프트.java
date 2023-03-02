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
        
        int n = scan.nextInt();
        String str = scan.next();
        char[] ch = new char[str.length()];

        for(int i = 0 ; i < ch.length ; i++){
            ch[i] = str.charAt(i);
        }

        while(n != 1){
            str = scan.next();
            for(int i = 0 ; i < ch.length ; i++){
                if(ch[i]!=str.charAt(i)) ch[i] = '?';
            }
            n--;
        }
        for(int i = 0 ; i < ch.length ; i++){
            System.out.print(ch[i]);
        }
    }
}