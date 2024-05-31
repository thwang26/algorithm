import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int windowSize = (int) Arrays.stream(str.split(""))
                .filter(e -> e.equals("a"))
                .count();
        int length = str.length();
        String cycleStr = str.repeat(2);

        int min = IntStream.rangeClosed(0, length)
                .mapToObj(i -> cycleStr.substring(i, i + windowSize))
                .mapToInt(s -> (int) Arrays.stream(s.split(""))
                        .filter(e -> e.equals("b"))
                        .count())
                .min()
                .getAsInt();
        
        System.out.println(min);
    }
}
