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
		Map<String, Boolean> map = new HashMap<>();
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		List<String> list = new ArrayList<>();
		String str;

		for(int i = 0 ; i < n ; i++){
			map.put(scan.next(), false);
		}
		for(int i = 0 ; i < m ; i++){
			str = scan.next();
			if(map.containsKey(str)) {
				list.add(str);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(String answer : list){
			System.out.println(answer);
		}
    }

}