import java.util.Arrays;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
    static Stack<Integer> s3 = new Stack<>();
    static Stack<Integer> s4 = new Stack<>();

    static String makeStack(int[] arr, Stack[] stackArr){
        
        for(int i = 0 ; i < arr.length ; i++){
            
            int num = arr[i];

            for(Stack st: stackArr){
                
                if((int)st.peek() < num){
                    
                    st.push(num);
                    num = 0;
                    break;
                    
                }
                
            }// stack 의 최상단 숫자보다 현재숫자가 더 크다면 넣음
            
            if(num != 0) return "NO";// 현재숫자가 어느 스택에도 들어가지 못한다면 NO return
            
        }// 입력받은 숫자만큼 반복
        
        return "YES";// 모든 숫자가 스택에 들어가 for문이 끝나면 YES return
        
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        
        int[] arr = Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        Stack[] stackArr = {s1, s2, s3, s4};

        for(Stack st: stackArr){
            
            st.push(0);
            
        }

        System.out.println(makeStack(arr, stackArr));
    }
}