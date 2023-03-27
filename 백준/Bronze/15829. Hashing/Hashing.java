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
	static final int M = 1234567891;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(bw.readLine());
		String str = new String(bw.readLine());
		long sum = 0;
		long pow = 1;
		char[] arr = str.toCharArray();
		for(int i = 0; i < L; i++)
		{
			sum += (arr[i] - 'a' + 1) * pow % M; //분배법칙
			pow = pow * 31 % M; //분배법칙
		}
		long hash = sum % M;
		System.out.println(hash);
	}
}