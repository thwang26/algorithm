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
import java.util.function.IntToLongFunction;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import java.util.Arrays;

public class Main {
    
    //백준
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        
        for(int i = Math.min(a, b) ; i >= 1 ; i--){
            if(a%i==0&&b%i==0){
                System.out.println(i);
                break;
            }
        }
        for(int i = Math.max(a, b) ; i <= a*b;  i++){
            if(i%a==0&&i%b==0){
                System.out.println(i);
                break;
            }
        }
        
        
    }
}