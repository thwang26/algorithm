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
        Scanner scan = new Scanner(System.in);

        int L = Integer.parseInt(scan.nextLine());
        String[] str = scan.nextLine().split("");
        long[] arr = new long[str.length];
        long sum = 0;

        for(int i = 0 ; i < str.length ; i++){
            arr[i] = str[i].charAt(0)-96L;
        }
        for(int i = 0 ; i < L ; i++){
            sum = sum + arr[i]*(long)Math.pow(31, i);
        }
        System.out.println(sum);
    }
}