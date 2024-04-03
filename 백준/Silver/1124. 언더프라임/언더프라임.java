import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean[] arr = makeArr(b);
        int count = 0;
        for (int i = a; i <= b; i++) {
            List<Integer> list = find(i);

            if (!arr[list.size()]) {
                count++;
            }
        }

        System.out.println(count);
    }

    static List<Integer> find(int n) {
        List<Integer> list = new ArrayList<>();

        int m = 2;
        while (n != 1) {
            if (n % m == 0) {
                list.add(m);
                n /= m;
            } else {
                m++;
            }
        }

        return list;
    }

    static boolean[] makeArr(int n) {
        boolean[] arr = new boolean[n + 1];

        arr[1] = true;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = i * 2; j < arr.length; j += i) {
                arr[j] = true;
            }
        }

        return arr;
    }
}
