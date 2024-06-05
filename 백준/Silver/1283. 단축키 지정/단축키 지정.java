import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(br.readLine());
        }

        list.stream().map(Main::match).forEach(System.out::println);
    }

    private static String match(String str) {
        String[] arr = str.split(" ");

        int firstLetterIdx = getFirstLetterIdx(arr);
        if (firstLetterIdx != -1) {
            String change = arr[firstLetterIdx];
            arr[firstLetterIdx] = parse(0, change);
            return String.join(" ", arr);
        }

        int remainLetterIdx = getRemainLetterIdx(str);
        if (remainLetterIdx != -1) {
            return parse(remainLetterIdx, str);
        }

        return str;
    }

    private static int getFirstLetterIdx(String[] arr) {
        int firstLetterIdx = IntStream.range(0, arr.length)
                .filter(i -> !set.contains(Character.toLowerCase(arr[i].charAt(0))))
                .findFirst()
                .orElse(-1);

        if (firstLetterIdx != -1) {
            set.add(Character.toLowerCase(arr[firstLetterIdx].charAt(0)));
        }

        return firstLetterIdx;
    }

    private static int getRemainLetterIdx(String str) {
        int remainLetterIdx = IntStream.range(0, str.length())
                .filter(i -> str.charAt(i) != ' ' && !set.contains(Character.toLowerCase(str.charAt(i))))
                .findFirst()
                .orElse(-1);

        if (remainLetterIdx != -1) {
            set.add(Character.toLowerCase(str.charAt(remainLetterIdx)));
        }

        return remainLetterIdx;
    }
    
    private static String parse(int idx, String str) {
        return str.substring(0, idx)
                + "[" + str.charAt(idx) + "]"
                + str.substring(idx + 1);
    }
}