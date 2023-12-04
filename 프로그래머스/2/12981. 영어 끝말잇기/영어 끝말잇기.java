import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> set = new HashSet<>();

        int idx = 1;
        set.add(words[0]);
        char beforeLastCharacter = words[0].charAt(words[0].length() - 1);
        while (idx < words.length) {
            String word = words[idx];
            if (set.contains(word) || beforeLastCharacter != word.charAt(0)) {
                answer[0] = idx % n + 1;
                answer[1] = idx / n + 1;
                break;
            }
            set.add(word);
            beforeLastCharacter = word.charAt(word.length() - 1);
            idx++;
        }

        return answer;
    }
}