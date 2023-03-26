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
 
	public static void main(String[] args) {
 
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int n = 0;
		long sum = 0;
		Stack<Integer> stack = new Stack<>();
		while(i != 0){
			n = scan.nextInt();
			if(n==0){
				stack.pop();
			}
			else stack.add(n);
			i--;
		}
		for(int num : stack){
			sum += num;
		}
		System.out.println(sum);
	
	}
}