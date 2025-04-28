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
            if (n - i <= mod) {
                arr[i] = div + 1;
            } else {
                arr[i] = div;
            }
        }

        return arr;
    }
}