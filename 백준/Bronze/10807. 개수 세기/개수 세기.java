import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int[] num = new int[n];
        for(int i = 0 ; i < n ; i++){
            num[i] = scan.nextInt();
        }
        int input = scan.nextInt();
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(num[i] == input) cnt++;
        }
        
        System.out.println(cnt);
    }
}