import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        for(int i = 1 ; i <= n ; i++){
            if(n%i == 0){
                k--;
                if(k==0) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println("0");
    }
}