import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        for (int each : arr) {
            map.put(each, map.getOrDefault(each, 0) + 1);
        }

        for (int each : arr) {
            for (int key : map.keySet()) {
                if ((each == key && map.get(each) < 2) || (each == each - key && map.get(each) < 2)) {
                    continue;
                }

                if (each == 0 && key == 0 && map.get(each) < 3) {
                    continue;
                }

                if (!map.containsKey(each - key)) {
                    continue;
                }

                if (each == key * 2 && map.get(key) >= 2) {
                    count++;
                    break;
                }

                if (each != key * 2 && map.containsKey(each - key)) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
