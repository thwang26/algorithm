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
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int test = 	scan.nextInt();
		
		while(test-- > 0){//테스트케이스 만큼 반복
			int n = scan.nextInt();
			int m = scan.nextInt();

			LinkedList<int[]> q = new LinkedList<>();//linkedlist 생성

			for(int i = 0 ; i < n ; i++){
				q.offer(new int[] { i , scan.nextInt() });
			}//q에 값 넣기

			int count = 0;

			while(!q.isEmpty()){
				int[] front = q.poll();//q의 제일 앞 값
				boolean isMax = true;

				for(int i = 0 ; i < q.size() ; i++){//q의 크기만큼 반복
					if(front[1] < q.get(i)[1]){//제일 앞 값이 뒤의 값 중 하나보다 작으면 뒤로
						q.offer(front);//제일 앞의 값 뒤로
						for(int j = 0 ; j < i ; j++){
							q.offer(q.poll());//찾은 값 이전까지 뒤로
						}
						isMax = false;//최대값 아님
						break;
					}
				}

				if(isMax == false){
					continue;//최대값이 아니라면 다시
				}

				count++;//인덱스 표시시
				if(front[0] == m){
					break;//인덱스가 찾는값의 인덱스와 같다면 종료
				}
			}
			System.out.println(count);
		}
	}
}