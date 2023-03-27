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
	
	static long BSearch(long tree[], long m) {
		long min = 0;
		long max = tree[tree.length-1];
		long cut;
		long length = 0;
		
		while(min<=max){
			long sum = 0;
			cut = (max+min)/2;
			// System.out.println("min="+min);
			// System.out.println("max="+max);
			// System.out.println("cut="+cut);
			for(int i = 0 ; i < tree.length ; i++){
				if(tree[i]-cut>0) sum += tree[i]-cut;
			}
			if(sum==m) {
				length = Math.max(length, cut);
				min = cut+1;
			}
			else if(sum>m) {
				length = Math.max(length, cut);
				min = cut + 1;
			}
			else  max = cut - 1;
			// System.out.println("sum="+sum);
			// System.out.println(length);
		}
		return length;
		
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int m = scan.nextInt();
		long[] tree = new long[n];

		for(int i = 0 ; i < n ; i++){
			tree[i] = scan.nextLong();
		}
		Arrays.sort(tree);
		System.out.println(BSearch(tree, m));
	}
}