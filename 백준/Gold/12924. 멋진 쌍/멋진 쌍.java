import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int a;
    static int b;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        for (int i = a; i <= b; i++) {
            makeGreatNumber(i);
        }

        System.out.println(count);
    }

    private static void makeGreatNumber(int i) {
        String str = String.valueOf(i);
        Set<Integer> set = new HashSet<>();
        for (int j = 1; j < str.length(); j++) {
            String left = str.substring(0, j);
            String right = str.substring(j);
            int reverseValue = Integer.parseInt(right + left);
            if (reverseValue > i && reverseValue <= b) {
                set.add(reverseValue);
            }
        }
        count += set.size();
    }
}
