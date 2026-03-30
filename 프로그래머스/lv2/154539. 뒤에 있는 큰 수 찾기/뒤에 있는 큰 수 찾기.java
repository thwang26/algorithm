import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < answer.length; i++) {
            int curNum = numbers[i];

            while(!stack.isEmpty()) {
                if (curNum <= numbers[stack.peek()]) {
                    break;
                }

                answer[stack.pop()] = curNum;
            }
            stack.push(i);
        }

        return answer;
    }
}