import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int n = s.length();
        String repeatS = s.repeat(2);

        return checkBracket(repeatS, n);
    }

    public int checkBracket(String repeatS, int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');

        int count = 0;

        for (int startIdx = 0; startIdx < n; startIdx++) {
            Stack<Character> stack = new Stack<>();
            String s = repeatS.substring(startIdx, startIdx + n);

            int idx = 0;
            while (idx < s.length()) {
                if (!stack.isEmpty() && map.containsKey(stack.peek()) &&
                        map.get(stack.peek()) == s.charAt(idx)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(idx));
                }
                
                idx++;
            }
            if (stack.isEmpty()) {
                count++;
            }
        }

        return count;
    }
}