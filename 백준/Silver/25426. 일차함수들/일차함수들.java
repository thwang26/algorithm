import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Number> list = new ArrayList<>();
        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Number(a, b));
        }

        list.sort(Comparator.comparingInt(o -> o.a));
        long sum = 0;
        long i = 1;
        for (Number num : list) {
            sum += num.a * i++ + num.b;
        }

        System.out.println(sum);
    }

    static class Number {
        int a;
        int b;

        public Number(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}