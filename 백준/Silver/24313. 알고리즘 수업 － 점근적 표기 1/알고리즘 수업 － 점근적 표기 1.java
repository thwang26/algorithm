import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a1 = scan.nextInt();
        int a0 = scan.nextInt();
        int c = scan.nextInt();
        int n0 = scan.nextInt();

        for(Long n = new Long(n0) ; n < 10000 ; n++){

            if(a1*n+a0 <= c*n){
                continue;
            }else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}