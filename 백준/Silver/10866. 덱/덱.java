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
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    //백준
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = 0;
        String cmd;
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            cmd = br.readLine();
            String[] split = cmd.split(" ");
            if(cmd.contains("push")){
                m = Integer.parseInt(split[1]);
                if(cmd.contains("front")){
                    deque.addFirst(m);
                }
                else {
                    deque.addLast(m);
                }
            }
            else if(cmd.contains("pop")){
                if(deque.isEmpty()) bw.write(-1+"\n");
                else if(cmd.contains("front")){
                    bw.write(deque.removeFirst()+"\n");
                }
                else{
                    bw.write(deque.removeLast()+"\n");
                }
            }
            else if(cmd.equals("size")){
                bw.write(deque.size()+"\n");
            }
            else if(cmd.equals("empty")){
                if(deque.isEmpty()) bw.write(1+"\n");
                else bw.write(0+"\n");
            }
            else if(cmd.equals("front")){
                if(deque.isEmpty()) bw.write(-1+"\n");
                else bw.write(deque.peekFirst()+"\n");
            }
            else if(cmd.equals("back")){
                if(deque.isEmpty()) bw.write(-1+"\n");
                else bw.write(deque.peekLast()+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}