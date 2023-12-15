import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String word) {
        int[] digit = {781, 156, 31, 6, 1};
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            int number = 1;
            count += number + map.get(word.charAt(i)) * digit[i];
        }
        
        return count;
    }
}