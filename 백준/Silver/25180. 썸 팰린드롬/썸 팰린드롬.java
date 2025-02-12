import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pal = n / 18 * 2;
        int remain = n % 18;

        if (remain > 0 && remain < 10) {
            pal++;
        } else if (remain >= 10) {
            if (remain % 2 == 0) {
                pal += 2;
            } else {
                pal += 3;
            }
        }

        System.out.println(pal);
    }
}