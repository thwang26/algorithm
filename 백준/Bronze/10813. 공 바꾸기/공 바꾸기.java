import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int[] arr = new int[n];
        int m = scan.nextInt();
        int tmp;
        
        for(int i = 1 ; i <= n ; i++){
            arr[i-1] = i;
        }
        // 배열 초기값

        while(m!=0){
            int i = scan.nextInt();
            int j = scan.nextInt();
            //int k = scan.nextInt();
            
            tmp = arr[i-1];
            arr[i-1] = arr[j-1];
            arr[j-1] = tmp;

            m--;
        }
        // 값 바꾸기

        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        // 완성된 배열 출력
    }
}