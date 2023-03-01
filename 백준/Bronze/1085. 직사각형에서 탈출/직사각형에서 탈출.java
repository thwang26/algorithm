import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int y = scan.nextInt();
        int w = scan.nextInt();
        int h = scan.nextInt();
        
        int min = 0;

        if(w/2 < x) x = w-x; 
        if(h/2 < y) y = h-y; 
        if(x > y) min = y;
        else min = x;
        
        System.out.println(min);
    }
}