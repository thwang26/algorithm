import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        long[] factorial = makeFactorial(n);
        List<Integer> numberList = makeNumberList(n);
        int[] answer = new int[n];

        int i = 0;
        while (n != 0) {
            long jump = (k - 1) / factorial[n - 1];
            k = k - jump * factorial[n - 1];

            answer[i] = numberList.get((int) jump);
            numberList.remove((Integer) answer[i]);
            i++;
            n--;
        }

        return answer;
    }

    public long[] makeFactorial(int n) {
        long[] factorial = new long[n];

        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        return factorial;
    }

    public List<Integer> makeNumberList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        return list;
    }
}