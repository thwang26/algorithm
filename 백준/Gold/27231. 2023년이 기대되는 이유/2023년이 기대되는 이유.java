import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            if (pow(n, 1) == pow(n, 2)) {
                System.out.println("Hello, BOJ 2023!");
                continue;
            }

            List<Integer> powList = makePowList(n);
            Set<Integer> plusSet = new HashSet<>();

            recur(0, String.valueOf(n), 0, plusSet);

            powList.retainAll(plusSet);
            System.out.println(powList.size());
        }
    }

    private static List<Integer> makePowList(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (true) {
            int pow = pow(n, i++);

            if (pow <= n) {
                list.add(pow);
            } else {
                break;
            }
        }

        return list;
    }

    private static int pow(int n, int i) {
        int sum = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            sum += Math.pow(c - '0', i);
        }

        return sum;
    }

    public static void recur(int idx, String str, int sum, Set<Integer> set) {
        if (idx == str.length()) {
            set.add(sum);
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            String part = str.substring(idx, i + 1);
            int num = Integer.parseInt(part);

            recur(i + 1, str, sum + num, set);
        }
    }
}