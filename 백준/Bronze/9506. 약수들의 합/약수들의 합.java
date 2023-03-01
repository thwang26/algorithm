import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){
            int sum = 0;
            int n = scan.nextInt();
            boolean perfect = false;
            
            if(n == -1) break;

            for(int i = 1 ; i < n ; i++){
                if(n%i == 0) sum += i;
                if(sum == n && i == n-1) perfect = true;
            }
            if(perfect == true){
                System.out.print(n+" = 1 ");
                for(int i = 2 ; i < n ; i++){
                    if(n%i == 0) System.out.print("+ "+i+" ");
                }
                System.out.println();
            }else System.out.println(n+" is NOT perfect.");
        }
    }
}