import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        if (str.startsWith("N")) {
            System.out.println("North London Collegiate School");
        } else if (str.startsWith("B")) {
            System.out.println("Branksome Hall Asia");
        } else if (str.startsWith("K")) {
            System.out.println("Korea International School");
        } else {
            System.out.println("St. Johnsbury Academy");
        }
    }
}