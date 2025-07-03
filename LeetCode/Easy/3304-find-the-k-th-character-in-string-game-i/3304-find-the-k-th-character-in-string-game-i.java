public class Solution {
    public char kthCharacter(int k) {
        int count = 0;
        int n = 1;
        while (n * 2 < k) {
            n *= 2;
        }
        while (k != 1) {
            k -= n;
            count++;
            while (n >= k) {
                n /= 2;
            }
        }
        return (char) ('a' + count);
    }
}