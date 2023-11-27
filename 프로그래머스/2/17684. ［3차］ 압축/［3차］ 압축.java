import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf((char) i), i - 'A' + 1);
        }


        String c;
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        int lastNumber = 26;
        while (idx < msg.length()) {
            String w = String.valueOf(msg.charAt(idx++));
            while (idx < msg.length()) {
                c = String.valueOf(msg.charAt(idx));
                if (map.containsKey(w + c)) {
                    w += c;
                    idx++;
                } else {
                    map.put(w + c, ++lastNumber);
                    break;
                }
            }

            list.add(map.get(w));
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}