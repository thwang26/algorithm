import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<BigInteger> fibonacci = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        makeFibonacci();

        while (true) {
            BigInteger a = new BigInteger(sc.next());
            BigInteger b = new BigInteger(sc.next());

            if (equalsZero(a) && equalsZero(b)) {
                break;
            }

            System.out.println(countOfFibonacci(a, b));
        }
    }

    private static void makeFibonacci() {
        BigInteger maxValue = new BigInteger(1 + "0".repeat(100));

        fibonacci.add(new BigInteger(String.valueOf(1)));
        fibonacci.add(new BigInteger(String.valueOf(2)));
        while (fibonacci.get(fibonacci.size() - 1).compareTo(maxValue) <= 0) {
            BigInteger nMinus2 = fibonacci.get(fibonacci.size() - 2);
            BigInteger nMinus1 = fibonacci.get(fibonacci.size() - 1);
            fibonacci.add(nMinus1.add(nMinus2));
        }
    }

    private static boolean equalsZero(BigInteger bi) {
        return bi.compareTo(BigInteger.valueOf(0)) == 0;
    }

    private static int countOfFibonacci(BigInteger a, BigInteger b) {
        return (int) fibonacci.stream()
                .filter(current -> current.compareTo(a) >= 0 && current.compareTo(b) <= 0)
                .count();
    }
}
