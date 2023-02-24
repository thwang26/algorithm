import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Long n = scan.nextLong();
        System.out.println(n*(n-1)/2);
        System.out.println("2");
    }
}