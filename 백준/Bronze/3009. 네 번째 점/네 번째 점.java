import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int ax = scan.nextInt();
        int ay = scan.nextInt();
        int bx = scan.nextInt();
        int by = scan.nextInt();
        int cx = scan.nextInt();
        int cy = scan.nextInt();
        int dx;
        int dy;
        
        if(ax == bx) dx=cx;
        else if(ax == cx) dx=bx;
        else dx=ax;

        if(ay == by) dy=cy;
        else if(ay == cy) dy=by;
        else dy=ay;

        System.out.println(dx+" "+dy);
    }
}