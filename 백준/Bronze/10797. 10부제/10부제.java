import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long count = IntStream.range(0, 5).map(i -> sc.nextInt()).filter(i -> n == i).count();

        System.out.println(count);
    }
}
