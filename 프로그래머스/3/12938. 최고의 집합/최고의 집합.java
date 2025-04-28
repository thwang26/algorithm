import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int mod = s % n;
        int div = s / n;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = div + (n - i <= mod ? 1 : 0);
        }

        return arr;
    }
}