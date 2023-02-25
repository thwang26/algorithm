import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T!=0){
            String str = scan.next();
            System.out.println(str.substring(0,1)+str.substring(str.length()-1));
            T--;
        }
    }
}