import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] num = new int[30];
        for(int i = 0 ; i < 28 ; i++){
            num[scan.nextInt()-1] = 1;
        }
        for(int i = 0 ; i < 30 ; i++){
            if(num[i] == 1) continue; 
            else System.out.println(i+1);
        }
    }
}