import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int max = -1;
        int[][] arr = new int[9][9];
        int x = 0;
        int y = 0;

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                arr[i][j] = scan.nextInt();
                if(max<arr[i][j]) {
                    max = arr[i][j];
                    x = i+1;
                    y = j+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(x+" "+y);
    }
}