import java.util.List;

public class Solution {
    int maxVowels = 0;

    public int maxVowels(String s, int k) {
        int vowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vowels++;
            }
        }
        
        maxVowels = vowels;

        int left = 1;
        int right = left + k - 1;
        while (right < s.length()) {
            if (isVowel(s.charAt(left - 1))) {
                vowels--;
            }

            if (isVowel(s.charAt(right))) {
                vowels++;
            }

            maxVowels = Math.max(maxVowels, vowels);

            left++;
            right++;
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';    
    }
}
