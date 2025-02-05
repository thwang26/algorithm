import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            String str = sc.next();
            String current = String.valueOf(str.charAt(0) - 'A' + 1) +
                    (str.charAt(1) - '1' + 1);

            if (list.contains(current)) {
                System.out.println("Invalid");
                return;
            }

            list.add(current);

            if (list.size() >= 2 && !canMove(list.get(i - 1), current)) {
                System.out.println("Invalid");
                return;
            }
        }

        if (list.size() == 36 && canMove(list.get(0), (list.get(35)))) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    private static boolean canMove(String s1, String s2) {
        int m1 = Math.abs(s1.charAt(0) - s2.charAt(0));
        int m2 = Math.abs(s1.charAt(1) - s2.charAt(1));
        return m1 != 0 && m2 != 0 && m1 + m2 == 3;
    }
}
