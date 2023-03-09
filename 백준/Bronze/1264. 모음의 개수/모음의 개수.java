import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int cnt;
        
        while(true){
            cnt = 0;
            String str = scan.nextLine();
            for(int i = 0 ; i < str.length() ; i++){
                if(str.charAt(i) == 'a') cnt++;
                else if(str.charAt(i) == 'e') cnt++;
                else if(str.charAt(i) == 'i') cnt++;
                else if(str.charAt(i) == 'o') cnt++;
                else if(str.charAt(i) == 'u') cnt++;
                else if(str.charAt(i) == 'A') cnt++;
                else if(str.charAt(i) == 'E') cnt++;
                else if(str.charAt(i) == 'I') cnt++;
                else if(str.charAt(i) == 'O') cnt++;
                else if(str.charAt(i) == 'U') cnt++;
            }
            if(str.equals("#")) break;
            System.out.println(cnt);
        }
    }
}