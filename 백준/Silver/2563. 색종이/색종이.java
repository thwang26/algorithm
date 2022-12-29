import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[][] whitePaper = new int[100][100];
        int x = 0; 
        int y = 0;
        int sum = 0;
        int cnt = scan.nextInt();
        
        for(int n = 0 ; n < cnt ; n++){
            x = scan.nextInt();
            y = scan.nextInt();
            for(int i = y ; i < y+10 ; i++){
                for(int j = x ; j < x+10 ; j++){
                    if(whitePaper[i][j] == 0) whitePaper[i][j] = 1;
                }
            }
        }
        for(int i = 0 ; i < 100 ; i++){
            for(int j = 0 ; j < 100 ; j++){
                if(whitePaper[i][j] == 1) sum += 1;
            }
        }
        System.out.println(sum);
    }
}