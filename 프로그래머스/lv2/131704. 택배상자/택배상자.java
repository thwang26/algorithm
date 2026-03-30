import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int count = 0;

        for (int i = 1; i <= order.length; i++) {
            if (order[idx] != i) {
                stack.add(i);
                continue;
            }

            idx++;
            count++;

            while (stack.size() != 0 && order[idx] == stack.peek()) {
                stack.pop();
                idx++;
                count++;
            }
        }

        return count;
    }
}