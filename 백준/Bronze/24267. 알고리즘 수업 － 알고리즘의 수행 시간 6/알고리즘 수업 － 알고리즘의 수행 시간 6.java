import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Long n = scan.nextLong();
        System.out.println((n-2)*(n-1)*n/6);
        System.out.println("3");
    }
}