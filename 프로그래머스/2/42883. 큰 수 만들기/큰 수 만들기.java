import java.util.Stack;

public class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            int n = (int) number.charAt(i) - '0';

            while (!stack.isEmpty() && stack.peek() < n && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(n);
        }

        StringBuilder sb = new StringBuilder();
        int count = stack.size() - k;
        for (int n : stack) {
            if (count == 0) {
                break;
            }
            sb.append(n);
            count--;
        }

        return sb.toString();
    }
}