import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void apart(int k, int n){
        int[][] arr = new int[15][15];
        int human = 0;

        for(int i = 0 ; i < 15 ; i++){
            arr[0][i] = i+1;
            arr[i][0] = 1;
        }

        for(int i = 1 ; i < 15 ; i++){
            for(int j = 1 ; j < 15 ; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        human = arr[k][n-1];
        
        System.out.println(human);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while(T != 0){
            int k = scan.nextInt();
            int n = scan.nextInt();

            apart(k, n);
            T--;
        }
        
    }
}