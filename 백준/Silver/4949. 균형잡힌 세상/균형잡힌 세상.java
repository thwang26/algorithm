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

		while(true){
			boolean bl = true;
			int small = 0;
			int big = 0;
			String str = scan.nextLine();

			if(str.equals(".")) break;

			Stack<Character> stack = new Stack<>(); 
			for(int i = 0 ; i < str.length() ; i++){
				if(str.charAt(i)=='(') {
					small++;
					stack.add('(');
				}
				else if(str.charAt(i)=='[') {
					big++;
					stack.add('[');
				}
				else if(str.charAt(i)==')') {
					small--;
					if(stack.isEmpty() || stack.peek()!='(') {
						bl = false;
						break;
					}
					else stack.pop();
				}
				else if(str.charAt(i)==']') {
					big--;
					if(stack.isEmpty() || stack.peek()!='[') {
						bl = false;
						break;
					}
					else stack.pop();
				}

				if(small < 0 || big < 0) {
					bl = false;
					break;
				}
			}
			if(small != 0 || big != 0) bl = false;

			System.out.println(bl == true ? "yes" : "no" );
		}
	}
}