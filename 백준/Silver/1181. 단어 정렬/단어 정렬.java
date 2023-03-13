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

    static class Sort implements Comparable<Sort> {
    
        String str;
    
        Sort(String str){
            this.str = str;
        }
    
        @Override
        public int compareTo(Sort o) {
            if(this.str.length() < o.str.length()){
                return -1;
            } else if(this.str.length() > o.str.length()){
                return 1;
            } else {
                for(int i = 0 ; i < str.length() ; i++){
                    if(this.str.charAt(i) == o.str.charAt(i)) continue;
                    else return this.str.charAt(i) - o.str.charAt(i);
                }
                return 0;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
        int n = Integer.parseInt(scan.nextLine());
        String[] str = new String[n];

        for(int i = 0 ; i < n ; i++){
            str[i] = scan.nextLine();
        }
        
        // 배열을 LinkedHashSet으로 변환
        LinkedHashSet<String> linkedHashSet = 
        new LinkedHashSet<>(Arrays.asList(str));
        
        // LinkedHashSet을 배열로 변환
        String[] updateStr = linkedHashSet.toArray(new String[0]);
        
        Sort[] s = new Sort[updateStr.length];
        for(int i = 0 ; i < s.length ; i++){
            s[i] = new Sort(updateStr[i]);
        }
        Arrays.sort(s);
        for(int i = 0 ; i < s.length ; i++){
            System.out.println(s[i].str);
        }
    }
}