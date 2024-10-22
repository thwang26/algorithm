import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Chocolate chocolate = new Chocolate();
        chocolate.arr = new int[n];
        for (int i = 0; i < chocolate.arr.length; i++) {
            chocolate.arr[i] = sc.nextInt();
        }

        chocolate.min = chocolate.arr[0];
        chocolate.day = 0;
        IntStream.range(1, chocolate.arr.length).forEach(chocolate::eatChocolate);

        System.out.printf("%d %d", chocolate.count, chocolate.day);
    }

    static class Chocolate {
        int[] arr;
        int min;
        int count;
        int day;

        public void eatChocolate(int i) {
            int count = arr[i] - min;
            if (count > 0) {
                this.count += count;
                day++;
            }
        }
    }
}
