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

import javax.sound.sampled.SourceDataLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
        int n = scan.nextInt();
        int count = 0;
        for(int i = 0 ; i <= n ; i++){
            if(i!=0&&i%5==0) {
                for(int m = 5; m <= i ; m *= 5){
                    if(i%m==0) count++;
                }
            }
        }
        System.out.println(count);
    }

}