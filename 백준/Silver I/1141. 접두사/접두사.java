import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<String> set = new HashSet<>();
        while (n-- > 0) {
            String str = sc.next();
            set.add(str);
        }

        int count = set.size();
        for (String str : set) {
            for (String each : set) {
                if (!str.equals(each) && each.startsWith(str)) {
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
