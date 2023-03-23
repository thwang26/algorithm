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
        int n = Integer.parseInt(scan.nextLine());
        String str;
        int gual;

        for(int i = 0 ; i < n ; i++){
            str = scan.nextLine();
            gual = 0;
            for(int j = 0 ; j < str.length() ; j++){
                if(str.charAt(j)=='(') gual++;
                else gual--;
                if(gual<0) {
                    bw.write("NO\n");
                    break;
                }
            }
            if(gual==0) bw.write("YES\n");
            else if(gual>0) bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }
}