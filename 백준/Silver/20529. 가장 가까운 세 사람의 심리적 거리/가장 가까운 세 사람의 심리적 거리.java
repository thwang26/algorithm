import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            
            List<String> mbti = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                mbti.add(sc.next());
            }
            
            if (n > 32) {
                System.out.println(0);
                continue;
            }

            int minValue = 100;
            for (int i = 0; i < mbti.size() - 2; i++) {
                for (int j = i + 1; j < mbti.size() - 1; j++) {
                    for (int k = j + 1; k < mbti.size(); k++) {
                        int value = 0;
                        value += getValue(mbti.get(i), mbti.get(j));
                        value += getValue(mbti.get(j), mbti.get(k));
                        value += getValue(mbti.get(k), mbti.get(i));
                        minValue = Math.min(minValue, value);
                    }
                }
            }

            System.out.println(minValue);
        }
    }

    private static int getValue(String a, String b) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                value++;
            }
        }

        return value;
    }
}
