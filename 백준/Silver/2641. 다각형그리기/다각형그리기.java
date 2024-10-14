import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] standardArr = new int[n];
        for (int i = 0; i < n; i++) {
            standardArr[i] = sc.nextInt();
        }

        List<String> standard = new ArrayList<>();
        standard.add(arrayToStr(standardArr).repeat(2));
        standard.add(reverse(standardArr).repeat(2));

        int draw = sc.nextInt();
        List<String> drawable = new ArrayList<>();
        while (draw-- > 0) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            String str = arrayToStr(arr);
            if (standard.stream().anyMatch(each -> each.contains(str))) {
                drawable.add(String.join(" ", str.split("")));
            }
        }

        System.out.println(drawable.size());
        drawable.forEach(System.out::println);
    }

    private static String reverse(int[] arr) {
        return new StringBuilder(Arrays.stream(arr)
                .map(n -> n > 2 ? n - 2 : n + 2)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()))
                .reverse()
                .toString();
    }

    public static String arrayToStr(int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}
