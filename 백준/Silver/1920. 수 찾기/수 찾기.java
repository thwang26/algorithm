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
    
    public int BSearch(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
    
        while(low <= high) {
            mid = (low + high) / 2;
    
            if (arr[mid] == target)
                return 1;
            else if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }

    //백준
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0 ; i < m ; i++){
            arr2[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        Main main = new Main();
        for(int i = 0 ; i < m ; i++){
            System.out.println(main.BSearch(arr, arr2[i]));
        }
    }
}