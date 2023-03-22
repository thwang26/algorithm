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
        String cmd;
        Stack<Integer> st = new Stack<>();

        for(int i = 1 ; i <= n ; i++){
            cmd = scan.nextLine();
            String[] split = cmd.split(" ");
            if(cmd.contains("push")){
                st.push(Integer.parseInt(split[1]));
            }//
            else if(cmd.equals("pop")){
                if(st.empty()) bw.write(-1+"\n");
                else bw.write(st.pop()+"\n");
            }//
            else if(cmd.equals("size")){
                bw.write(st.size()+"\n");
            }//
            else if(cmd.equals("empty")){
                if(st.empty()) bw.write(1+"\n");
                else bw.write(0+"\n");
            }
            else if(cmd.equals("top")){
                if(st.empty()) bw.write(-1+"\n");
                else bw.write(st.peek()+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}