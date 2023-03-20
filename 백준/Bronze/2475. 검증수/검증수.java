import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int sum = 0;
        int n;

        int cnt = 5;
        while(cnt != 0){
            n = scan.nextInt();
            sum += n*n;
            cnt--;
        }

        System.out.println(sum%10);
    }
}