import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] n = scan.next().split("");

        Arrays.sort(n);
        for(int i = n.length-1 ; i >= 0 ; i--){
            System.out.print(n[i]);
        }
    }
}