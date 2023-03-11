import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
        char[][] chess = new char[8][8];
        String str;
        int cnt = 0;

        for(int i = 0 ; i < 8 ; i++){
            str = scan.nextLine();

            for(int j = 0 ; j < 8 ; j++){
                chess[i][j] = str.charAt(j);
                if(i%2==0){
                    if(j%2==0 && chess[i][j]=='F') cnt++;
                }
                else{
                    if(j%2==1 && chess[i][j]=='F') cnt++;
                }
            }
        }
        System.out.println(cnt);
        
    }
}