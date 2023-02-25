import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        int[] rev = new int[n];
        
        for(int i = 1 ; i <= n ; i++){
            arr[i-1] = i;
        }
        // 배열 초기값
        while(m!=0){
            int i = scan.nextInt();
            int j = scan.nextInt();
            
            if(i!=j){ // i와j가 같으면 값을 뒤집을 필요가 없음
                for(int x = i ; x <= j ; x++){
                    rev[i+j-x-1] = arr[x-1];
                }
                // rev 배열에 arr 배열의 값을 뒤집어 넣음
                
                for(int x = i ; x <= j ; x++){
                    arr[x-1] = rev[x-1];
                }
                // rev 배열의 값을 다시 arr 배열에 넣음
            }
            m--;
        }
        // 값 바꾸기

        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        // 완성된 배열 출력
    }
}