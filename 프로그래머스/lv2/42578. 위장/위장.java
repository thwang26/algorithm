import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        int cnt = 1; // 총 경우의 수 (모든 경우의 수 - 하나도 입지않는 경우의 수)

        for (String[] parts: clothes) {
            if (map.containsKey(parts[1])) {
                map.put(parts[1], map.get(parts[1]) + 1);
            } else {
                map.put(parts[1], 1);
            }
        }

        for (int value: map.values()) {
            cnt *= (value + 1); // 옷을 입지 않는 경우까지 +1
        }

        answer = cnt - 1; // 옷을 하나도 입지 않는 경우 빼줌

        return answer;
    }
}