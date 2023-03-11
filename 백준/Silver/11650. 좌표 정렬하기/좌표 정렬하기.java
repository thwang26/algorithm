import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Sort implements Comparable<Sort> {
    
        int str1;
        int str2;
    
        Sort(int str1, int str2){
            this.str1 = str1;
            this.str2 = str2;
        }
    
        @Override
        public int compareTo(Sort o) {
            if(this.str1 < o.str1){
                return -1;
            } else if(this.str1 > o.str1){
                return 1;
            } else {
                return this.str2 - o.str2;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
        int n = Integer.parseInt(scan.nextLine());
        String[] str = new String[n];

        Sort[] s = new Sort[n];
        for(int i = 0 ; i < n ; i++){
            str[i] = scan.nextLine();
            int str1 = Integer.parseInt(str[i].split(" ")[0]);
            int str2 = Integer.parseInt(str[i].split(" ")[1]);
            s[i] = new Sort(str1, str2);
        }
        Arrays.sort(s);
        for(int i = 0 ; i < n ; i++){
            System.out.println(s[i].str1+" "+s[i].str2);
        }
    }
}