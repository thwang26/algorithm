import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        // 스택에 인덱스 넣어서 사용
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        stack.add(0);
        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty()) {
                if (prices[stack.peek()] > prices[i]) {
                    answer[stack.peek()] = i - stack.pop();
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        int num = prices.length - 1;
        while (!stack.isEmpty()) {
            answer[stack.peek()] = num - stack.pop();
        }
        
        return answer;
    }
}