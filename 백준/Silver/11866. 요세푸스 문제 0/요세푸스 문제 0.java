import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    //백준
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt()-1;
        int j = k;
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            list.add(i);
        }
       System.out.print("<");
        for(int i = 0 ; i < n ; i++){
            System.out.print(list.get(j));
            if(list.size()!=1) System.out.print(", ");
            list.remove(j);
            j=k+j;
            while(j>=list.size()&&list.size()!=0){
                j = j-list.size();
            }
        }
        System.out.println(">");
    }
}