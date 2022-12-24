import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        int item = scan.nextInt();
        int price;
        int qty;
        long totalPrice = 0;
        for(int i = 1 ; i <= item ; i++){
            price = scan.nextInt();
            qty = scan.nextInt();
            totalPrice += price*qty;
        }
        String result = (sum == totalPrice) ? "Yes" : "No";
        System.out.println(result);
    }
}