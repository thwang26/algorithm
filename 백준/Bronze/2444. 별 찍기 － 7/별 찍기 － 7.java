import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i = 1 ; i <= 2*n-1 ; i++){
            for(int a = 1 ; a <= Math.abs(n-i) ; a++) System.out.print(" ");    
            for(int a = 1 ; a <= -(Math.abs(2*n-2*i))+(2*n-1) ; a++) System.out.print("*");
            System.out.println(" ");
        }
    }
}