import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Character, Integer> weights = new HashMap<>();
        while (n-- > 0) {
            String word = br.readLine();
            int power = 1;
            for (int i = word.length() - 1; i >= 0; i--) {
                weights.put(word.charAt(i), weights.getOrDefault(word.charAt(i), 0) + power);
                power *= 10;
            }
        }

        List<Integer> sortedWeights = new ArrayList<>(weights.values());
        sortedWeights.sort(Collections.reverseOrder());

        int result = 0;
        int score = 9;
        for (int each : sortedWeights) {
            result += each * score--;
        }

        System.out.println(result);
    }
}
