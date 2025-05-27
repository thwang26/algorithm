
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static Map<String, Integer> map = makeMap();
    static List<String> list = new ArrayList<>();
    static int score = 0;
    static Map<String, Integer> scoreMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            list.add(br.readLine());
        }

        sumValue();
        makeScore();

        System.out.println(score);
    }

    private static Map<String, Integer> makeMap() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), 0);
        }
        return map;
    }

    private static void sumValue() {
        for (String each : list) {
            int num = 1;
            for (int i = each.length() - 1; i >= 0; i--) {
                String current = String.valueOf(each.charAt(i));
                map.put(current, map.get(current) + num);
                num *= 10;
            }
        }
    }

    private static void makeScore() {
        List<String> key = map.keySet()
                .stream()
                .sorted((o1, o2) -> map.get(o2) - map.get(o1))
                .collect(Collectors.toList());
        int score = 9;
        for (String each : key) {
            if (score < 0) {
                break;
            }
            scoreMap.put(each, score--);
        }

        for (String each : list) {
            alphabetToScore(each);
        }
    }

    private static void alphabetToScore(String each) {
        int mul = 1;
        for (int i = each.length() - 1; i >= 0; i--) {
            score += scoreMap.get(String.valueOf(each.charAt(i))) * mul;
            mul *= 10;
        }
    }
}
