import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static int[] mountain;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        mountain = new int[n];
        for (int i = 0; i < mountain.length; i++) {
            mountain[i] = sc.nextInt();
        }

        int sum = IntStream.range(0, mountain.length - 1).map(i -> getWireLength(i)).sum();
        System.out.println(sum);
    }

    public static int getWireLength(int i) {
        return (int) (2 * Math.pow(mountain[i], 2) + 2 * Math.pow(mountain[i + 1], 2));
    }
}
