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
        int[] cardArr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] cardArr2 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(cardArr);

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : cardArr){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else map.put(num, map.get(num)+1);
        }
        for(int num : cardArr2){
            if(map.containsKey(num)) bw.write(map.get(num)+" ");
            else bw.write(0+" ");
        }
        bw.flush();
        bw.close();
    }
}