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

    public static void BSearch(int lan, Long cnt, int[] arr, int k, int n) {
        Long low = 0L;
        Long high = Long.valueOf(lan);
        Long mid;
        Long maxLan = Long.valueOf(Integer.MIN_VALUE);
        
        while(low <= high) {
            cnt = 0L;
            mid = (low + high) / 2;
    
            for(int i = 0 ; i < n ; i++){
                cnt += arr[i]/mid;
            }
            
            if (cnt >= k){
                if(maxLan<mid) maxLan = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println(maxLan);
    }
        
    //백준
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int[] arr = new int[n];
        Long cnt = 0L;
        int lan;
    
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }   
        //Arrays.sort(arr);
        //lan = arr[arr.length-1];
        lan = Integer.MAX_VALUE;
        BSearch(lan, cnt, arr, k, n);
    }
}